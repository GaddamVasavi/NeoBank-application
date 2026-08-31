package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface BillDisputeInvestigationRepository extends JpaRepository<BillDisputeInvestigation, UUID> {
    List<BillDisputeInvestigation> findByUserId(UUID userId);
    Optional<BillDisputeInvestigation> findByRecordKey(String recordKey);
    List<BillDisputeInvestigation> findByStatus(String status);
}
