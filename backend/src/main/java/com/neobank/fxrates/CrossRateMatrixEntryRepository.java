package com.neobank.fxrates;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CrossRateMatrixEntryRepository extends JpaRepository<CrossRateMatrixEntry, UUID> {
    List<CrossRateMatrixEntry> findByUserId(UUID userId);
    Optional<CrossRateMatrixEntry> findByRegistryKey(String key);
    List<CrossRateMatrixEntry> findByDeliveryStatus(String status);
}
