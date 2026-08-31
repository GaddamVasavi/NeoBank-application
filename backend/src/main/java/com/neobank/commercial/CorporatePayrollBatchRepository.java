package com.neobank.commercial;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CorporatePayrollBatchRepository extends JpaRepository<CorporatePayrollBatch, UUID> {
    List<CorporatePayrollBatch> findByUserId(UUID userId);
    Optional<CorporatePayrollBatch> findByIdentifierCode(String code);
    List<CorporatePayrollBatch> findByStatus(String status);
}
