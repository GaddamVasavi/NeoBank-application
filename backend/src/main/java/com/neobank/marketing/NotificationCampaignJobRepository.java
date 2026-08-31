package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NotificationCampaignJobRepository extends JpaRepository<NotificationCampaignJob, UUID> {
    List<NotificationCampaignJob> findByUserId(UUID userId);
    Optional<NotificationCampaignJob> findByTrackingCode(String code);
    List<NotificationCampaignJob> findByStateFlag(String stateFlag);
}
