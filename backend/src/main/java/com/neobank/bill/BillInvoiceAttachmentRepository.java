package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BillInvoiceAttachmentRepository extends JpaRepository<BillInvoiceAttachment, UUID> {
    List<BillInvoiceAttachment> findByUserId(UUID userId);
    Optional<BillInvoiceAttachment> findByRecordKey(String recordKey);
    List<BillInvoiceAttachment> findByStatus(String status);
}
