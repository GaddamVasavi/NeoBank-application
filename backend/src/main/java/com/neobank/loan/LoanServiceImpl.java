package com.neobank.loan;

import com.neobank.account.Account;
import com.neobank.account.AccountRepository;
import com.neobank.audit.AuditAction;
import com.neobank.audit.AuditService;
import com.neobank.audit.AuditSeverity;
import com.neobank.common.BadRequestException;
import com.neobank.common.ResourceNotFoundException;
import com.neobank.transaction.Transaction;
import com.neobank.transaction.TransactionRepository;
import com.neobank.transaction.TransactionStatus;
import com.neobank.transaction.TransactionType;
import com.neobank.user.User;
import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanProductRepository productRepository;
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final AuditService auditService;

    @Override @Transactional(readOnly = true) public List<LoanProduct> getLoanProducts() { return productRepository.findAll(); }
    @Override @Transactional(readOnly = true) public List<Loan> getUserLoans(UUID userId) { return loanRepository.findByUserId(userId); }

    @Override
    public BigDecimal calculateEmi(BigDecimal principal, BigDecimal rate, int months) {
        double r = rate.doubleValue() / (12 * 100);
        double emi = (principal.doubleValue() * r * Math.pow(1 + r, months)) / (Math.pow(1 + r, months) - 1);
        return BigDecimal.valueOf(emi).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    @Transactional
    public Loan applyForLoan(UUID userId, UUID accountId, UUID productId, BigDecimal principal, int tenureMonths) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        LoanProduct product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Loan product not found"));

        BigDecimal emi = calculateEmi(principal, product.getInterestRate(), tenureMonths);
        BigDecimal totalPayable = emi.multiply(BigDecimal.valueOf(tenureMonths));
        String ref = "LOAN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Loan loan = Loan.builder()
                .user(user)
                .account(account)
                .product(product)
                .loanReference(ref)
                .loanType(product.getLoanType())
                .principalAmount(principal)
                .totalAmountPayable(totalPayable)
                .outstandingBalance(totalPayable)
                .interestRate(product.getInterestRate())
                .tenureMonths(tenureMonths)
                .monthlyInstallment(emi)
                .status("ACTIVE")
                .disbursedAt(Instant.now())
                .build();
        Loan saved = loanRepository.save(loan);

        // Disburse principal into customer account
        account.setBalance(account.getBalance().add(principal));
        account.setAvailableBalance(account.getAvailableBalance().add(principal));
        accountRepository.save(account);

        Transaction tx = Transaction.builder()
                .account(account)
                .referenceNumber(ref + "-DISB")
                .transactionType(TransactionType.LOAN_DISBURSEMENT)
                .category("LOAN")
                .amount(principal)
                .balanceAfter(account.getBalance())
                .description("Disbursement of " + product.getName())
                .status(TransactionStatus.COMPLETED)
                .transactionDate(Instant.now())
                .build();
        transactionRepository.save(tx);

        auditService.log(userId, user.getUsername(), AuditAction.LOAN_APPLY, "Loan", saved.getId().toString(), "SUCCESS", "Loan disbursed: " + ref, null, null, AuditSeverity.INFO);
        return saved;
    }
}
