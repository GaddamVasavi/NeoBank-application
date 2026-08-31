package com.neobank.account;

import com.neobank.common.BadRequestException;
import com.neobank.common.ResourceNotFoundException;
import com.neobank.transaction.Transaction;
import com.neobank.transaction.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    @Transactional(readOnly = true)
    public byte[] generatePdfStatement(UUID accountId, UUID userId, LocalDate startDate, LocalDate endDate) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");

        // PDF generation simulator returning binary payload
        String pdfContent = "%PDF-1.4\n1 0 obj << /Title (NeoBank Statement - Account " + account.getAccountNumber() + ") >> endobj\ntrailer << /Root 1 0 R >>\n%%EOF";
        return pdfContent.getBytes();
    }

    @Override
    @Transactional(readOnly = true)
    public String generateCsvStatement(UUID accountId, UUID userId, LocalDate startDate, LocalDate endDate) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");

        List<Transaction> transactions = transactionRepository.findByAccountIdOrderByTransactionDateDesc(accountId, PageRequest.of(0, 100)).getContent();
        StringBuilder csv = new StringBuilder();
        csv.append("Date,Reference,Type,Category,Description,Amount,Balance After\n");
        for (Transaction tx : transactions) {
            csv.append(tx.getTransactionDate()).append(",")
               .append(tx.getReferenceNumber()).append(",")
               .append(tx.getTransactionType()).append(",")
               .append(tx.getCategory()).append(",\"")
               .append(tx.getDescription().replace("\"", "\"\"")).append("\",")
               .append(tx.getAmount()).append(",")
               .append(tx.getBalanceAfter()).append("\n");
        }
        return csv.toString();
    }
}
