package com.neobank.card;

import com.neobank.account.Account;
import com.neobank.account.AccountRepository;
import com.neobank.audit.AuditAction;
import com.neobank.audit.AuditService;
import com.neobank.audit.AuditSeverity;
import com.neobank.common.BadRequestException;
import com.neobank.common.CryptoUtils;
import com.neobank.common.ResourceNotFoundException;
import com.neobank.user.User;
import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuditService auditService;

    @Override
    @Transactional(readOnly = true)
    public List<CardDto> getUserCards(UUID userId) {
        return cardRepository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CardDto issueCard(UUID userId, UUID accountId, CardType type, boolean isVirtual) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Account mismatch");

        String cardNumber = "4" + CryptoUtils.generateOtp(15);
        String cvv = CryptoUtils.generateOtp(3);
        LocalDate now = LocalDate.now();
        int expMonth = now.getMonthValue();
        int expYear = now.getYear() + 4;

        String cardholderName = user.getProfile() != null ? user.getProfile().getFullName() : user.getUsername().toUpperCase();

        Card card = Card.builder()
                .user(user)
                .account(account)
                .cardNumber(cardNumber)
                .cardholderName(cardholderName)
                .cardType(type)
                .cardNetwork("VISA")
                .status(CardStatus.ACTIVE)
                .expiryMonth(expMonth)
                .expiryYear(expYear)
                .cvvHash(passwordEncoder.encode(cvv))
                .virtual(isVirtual)
                .build();

        Card saved = cardRepository.save(card);
        auditService.log(userId, user.getUsername(), AuditAction.CARD_CREATE, "Card", saved.getId().toString(), "SUCCESS", "Card issued: " + mask(cardNumber), null, null, AuditSeverity.INFO);
        return mapToDto(saved);
    }

    @Override
    @Transactional
    public CardDto toggleFreeze(UUID userId, UUID cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        if (!card.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        if (card.getStatus() == CardStatus.ACTIVE) {
            card.setStatus(CardStatus.FROZEN);
            card.setFrozenAt(Instant.now());
        } else if (card.getStatus() == CardStatus.FROZEN) {
            card.setStatus(CardStatus.ACTIVE);
            card.setFrozenAt(null);
        }
        return mapToDto(cardRepository.save(card));
    }

    @Override
    @Transactional
    public CardDto updateControls(UUID userId, UUID cardId, boolean online, boolean international, boolean contactless, BigDecimal dailyLimit) {
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        if (!card.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        card.setOnlinePaymentsEnabled(online);
        card.setInternationalPaymentsEnabled(international);
        card.setContactlessEnabled(contactless);
        if (dailyLimit != null) card.setDailyLimit(dailyLimit);
        return mapToDto(cardRepository.save(card));
    }

    @Override
    @Transactional
    public void setPin(UUID userId, UUID cardId, String newPin) {
        if (newPin == null || newPin.length() != 4) throw new BadRequestException("PIN must be 4 digits");
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new ResourceNotFoundException("Card not found"));
        if (!card.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        card.setPinHash(passwordEncoder.encode(newPin));
        cardRepository.save(card);
    }

    private String mask(String num) {
        if (num == null || num.length() < 4) return "••••";
        return "•••• •••• •••• " + num.substring(num.length() - 4);
    }

    private CardDto mapToDto(Card c) {
        return CardDto.builder()
                .id(c.getId())
                .accountId(c.getAccount().getId())
                .maskedCardNumber(mask(c.getCardNumber()))
                .cardholderName(c.getCardholderName())
                .cardType(c.getCardType())
                .cardNetwork(c.getCardNetwork())
                .status(c.getStatus())
                .expiryMonth(c.getExpiryMonth())
                .expiryYear(c.getExpiryYear())
                .dailyLimit(c.getDailyLimit())
                .monthlyLimit(c.getMonthlyLimit())
                .onlinePaymentsEnabled(c.isOnlinePaymentsEnabled())
                .internationalPaymentsEnabled(c.isInternationalPaymentsEnabled())
                .contactlessEnabled(c.isContactlessEnabled())
                .atmWithdrawalsEnabled(c.isAtmWithdrawalsEnabled())
                .virtual(c.isVirtual())
                .build();
    }
}
