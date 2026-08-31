package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TaxLossHarvestingRecordRepository extends JpaRepository<TaxLossHarvestingRecord, UUID> {
    List<TaxLossHarvestingRecord> findByUserId(UUID userId);
    Optional<TaxLossHarvestingRecord> findByIdentifierCode(String code);
    List<TaxLossHarvestingRecord> findByStatus(String status);
}
