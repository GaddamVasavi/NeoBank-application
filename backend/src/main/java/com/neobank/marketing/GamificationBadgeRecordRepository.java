package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface GamificationBadgeRecordRepository extends JpaRepository<GamificationBadgeRecord, UUID> {
    List<GamificationBadgeRecord> findByUserId(UUID userId);
    Optional<GamificationBadgeRecord> findByTrackingCode(String code);
    List<GamificationBadgeRecord> findByStateFlag(String stateFlag);
}
