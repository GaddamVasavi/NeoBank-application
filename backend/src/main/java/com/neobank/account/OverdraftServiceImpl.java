package com.neobank.account;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; import java.math.BigDecimal;
@Service @RequiredArgsConstructor
public class OverdraftServiceImpl implements OverdraftService {
    private final AccountRepository accountRepository;
    @Override
    public boolean hasSufficientCover(Account primaryAccount, BigDecimal requiredAmount) {
        return primaryAccount.getAvailableBalance().compareTo(requiredAmount) >= 0;
    }
    @Override @Transactional
    public void sweepCover(Account primaryAccount, Account backupAccount, BigDecimal deficitAmount) {
        if (backupAccount.getAvailableBalance().compareTo(deficitAmount) >= 0) {
            backupAccount.setBalance(backupAccount.getBalance().subtract(deficitAmount));
            backupAccount.setAvailableBalance(backupAccount.getAvailableBalance().subtract(deficitAmount));
            primaryAccount.setBalance(primaryAccount.getBalance().add(deficitAmount));
            primaryAccount.setAvailableBalance(primaryAccount.getAvailableBalance().add(deficitAmount));
            accountRepository.save(backupAccount);
            accountRepository.save(primaryAccount);
        }
    }
}
