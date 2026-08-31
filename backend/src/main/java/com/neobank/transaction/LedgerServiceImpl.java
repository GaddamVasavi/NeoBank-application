package com.neobank.transaction;
import com.neobank.account.Account; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; import java.math.BigDecimal; import java.time.Instant;
@Service @RequiredArgsConstructor
public class LedgerServiceImpl implements LedgerService {
    private final DoubleEntryLedgerRepository ledgerRepository;
    @Override @Transactional
    public void postDoubleEntry(String ref, Account debitAccount, Account creditAccount, BigDecimal amount, String narration) {
        DoubleEntryLedger entry = DoubleEntryLedger.builder()
                .entryReference(ref)
                .debitAccount(debitAccount)
                .creditAccount(creditAccount)
                .amount(amount)
                .narration(narration)
                .postedAt(Instant.now())
                .build();
        ledgerRepository.save(entry);
    }
}
