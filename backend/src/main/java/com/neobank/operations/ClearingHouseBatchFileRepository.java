package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface ClearingHouseBatchFileRepository extends JpaRepository<ClearingHouseBatchFile, UUID> {
    List<ClearingHouseBatchFile> findByUserId(UUID userId);
    Optional<ClearingHouseBatchFile> findByTrackingCode(String code);
    List<ClearingHouseBatchFile> findByStateFlag(String stateFlag);
}
