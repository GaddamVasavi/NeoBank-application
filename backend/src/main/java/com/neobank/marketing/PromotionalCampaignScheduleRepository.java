package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PromotionalCampaignScheduleRepository extends JpaRepository<PromotionalCampaignSchedule, UUID> {
    List<PromotionalCampaignSchedule> findByUserId(UUID userId);
    Optional<PromotionalCampaignSchedule> findByTrackingCode(String code);
    List<PromotionalCampaignSchedule> findByStateFlag(String stateFlag);
}
