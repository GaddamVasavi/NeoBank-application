package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CustomerSegmentationRuleRepository extends JpaRepository<CustomerSegmentationRule, UUID> {
    List<CustomerSegmentationRule> findByUserId(UUID userId);
    Optional<CustomerSegmentationRule> findByTrackingCode(String code);
    List<CustomerSegmentationRule> findByStateFlag(String stateFlag);
}
