package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BillPaymentReceiptRepository extends JpaRepository<BillPaymentReceipt, UUID> {
    List<BillPaymentReceipt> findByUserId(UUID userId);
    Optional<BillPaymentReceipt> findByRecordKey(String recordKey);
    List<BillPaymentReceipt> findByStatus(String status);
}
