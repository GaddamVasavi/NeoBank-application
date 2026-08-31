package com.neobank.fraud;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface MuleAccountDetectorRepository extends JpaRepository<MuleAccountDetector, UUID> {
    List<MuleAccountDetector> findByUserId(UUID userId);
    Optional<MuleAccountDetector> findByRecordKey(String recordKey);
    List<MuleAccountDetector> findByStatus(String status);
}
