package com.neobank.bill;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
public interface BillService {
    List<Biller> getBillers();
    BillPayment payBill(UUID userId, UUID accountId, UUID billerId, String consumerNumber, BigDecimal amount);
    List<BillPayment> getAccountBillPayments(UUID userId, UUID accountId);
}
