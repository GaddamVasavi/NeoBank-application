package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BatchTransferJobRepository extends JpaRepository<BatchTransferJob, UUID> {
    List<BatchTransferJob> findBySourceAccountId(UUID accountId);
    Optional<BatchTransferJob> findByTrackingNumber(String trackingNumber);
    List<BatchTransferJob> findByStatus(String status);
}
