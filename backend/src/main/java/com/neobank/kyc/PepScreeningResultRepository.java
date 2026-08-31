package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PepScreeningResultRepository extends JpaRepository<PepScreeningResult, UUID> {
    List<PepScreeningResult> findByUserId(UUID userId);
    Optional<PepScreeningResult> findByRecordKey(String recordKey);
    List<PepScreeningResult> findByStatus(String status);
}
