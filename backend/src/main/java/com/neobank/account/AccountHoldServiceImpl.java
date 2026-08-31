package com.neobank.account;
import com.neobank.common.BadRequestException; import com.neobank.common.ResourceNotFoundException;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
@Service @RequiredArgsConstructor
public class AccountHoldServiceImpl implements AccountHoldService {
    private final AccountHoldRepository holdRepository; private final AccountRepository accountRepository;
    @Override @Transactional
    public AccountHold placeHold(UUID accountId, BigDecimal amount, String reason, String ref) {
        Account a = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (a.getAvailableBalance().compareTo(amount) < 0) throw new BadRequestException("Insufficient available funds for hold");
        a.setAvailableBalance(a.getAvailableBalance().subtract(amount));
        accountRepository.save(a);
        AccountHold hold = AccountHold.builder().account(a).amount(amount).holdReason(reason).referenceId(ref).active(true).build();
        return holdRepository.save(hold);
    }
    @Override @Transactional
    public void releaseHold(UUID holdId) {
        AccountHold hold = holdRepository.findById(holdId).orElseThrow(() -> new ResourceNotFoundException("Hold not found"));
        if (hold.isActive()) {
            hold.setActive(false);
            Account a = hold.getAccount();
            a.setAvailableBalance(a.getAvailableBalance().add(hold.getAmount()));
            accountRepository.save(a);
            holdRepository.save(hold);
        }
    }
    @Override @Transactional(readOnly = true) public List<AccountHold> getActiveHolds(UUID accountId) { return holdRepository.findByAccountIdAndActiveTrue(accountId); }
}
