package com.neobank.coreledger;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface JournalVoucherBatchRepository extends JpaRepository<JournalVoucherBatch, UUID> {
    List<JournalVoucherBatch> findByUserId(UUID userId);
    Optional<JournalVoucherBatch> findByCoreReference(String ref);
    List<JournalVoucherBatch> findByProcessingStatus(String status);
}
