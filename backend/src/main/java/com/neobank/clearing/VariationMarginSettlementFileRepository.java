package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface VariationMarginSettlementFileRepository extends JpaRepository<VariationMarginSettlementFile, UUID> {
    List<VariationMarginSettlementFile> findByUserId(UUID userId);
    Optional<VariationMarginSettlementFile> findByInstitutionalRef(String ref);
    List<VariationMarginSettlementFile> findByExecutionStatus(String status);
}
