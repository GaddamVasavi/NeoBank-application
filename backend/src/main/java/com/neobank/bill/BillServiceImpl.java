package com.neobank.bill;
import com.neobank.account.Account; import com.neobank.account.AccountRepository;
import com.neobank.common.BadRequestException; import com.neobank.common.ResourceNotFoundException;
import com.neobank.transaction.Transaction; import com.neobank.transaction.TransactionRepository;
import com.neobank.transaction.TransactionStatus; import com.neobank.transaction.TransactionType;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal; import java.time.Instant; import java.util.List; import java.util.UUID;
@Service @RequiredArgsConstructor
public class BillServiceImpl implements BillService {
    private final BillerRepository billerRepository;
    private final BillPaymentRepository billPaymentRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    @Override @Transactional(readOnly = true) public List<Biller> getBillers() { return billerRepository.findAll(); }
    @Override @Transactional
    public BillPayment payBill(UUID userId, UUID accountId, UUID billerId, String consumerNumber, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        if (account.getAvailableBalance().compareTo(amount) < 0) throw new BadRequestException("Insufficient balance");
        Biller biller = billerRepository.findById(billerId).orElseThrow(() -> new ResourceNotFoundException("Biller not found"));
        account.setBalance(account.getBalance().subtract(amount));
        account.setAvailableBalance(account.getAvailableBalance().subtract(amount));
        accountRepository.save(account);
        String ref = "BILL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Transaction tx = Transaction.builder().account(account).referenceNumber(ref).transactionType(TransactionType.BILL_PAYMENT).category(biller.getCategory()).amount(amount.negate()).balanceAfter(account.getBalance()).description("Bill payment to " + biller.getName()).status(TransactionStatus.COMPLETED).transactionDate(Instant.now()).build();
        transactionRepository.save(tx);
        BillPayment payment = BillPayment.builder().account(account).biller(biller).referenceId(ref).consumerNumber(consumerNumber).amount(amount).status("COMPLETED").paidAt(Instant.now()).build();
        return billPaymentRepository.save(payment);
    }
    @Override @Transactional(readOnly = true)
    public List<BillPayment> getAccountBillPayments(UUID userId, UUID accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (!account.getUser().getId().equals(userId)) throw new BadRequestException("Forbidden");
        return billPaymentRepository.findByAccountIdOrderByPaidAtDesc(accountId);
    }
}
