package com.neobank.marketing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PartnerMerchantOfferRecordRepository extends JpaRepository<PartnerMerchantOfferRecord, UUID> {
    List<PartnerMerchantOfferRecord> findByUserId(UUID userId);
    Optional<PartnerMerchantOfferRecord> findByTrackingCode(String code);
    List<PartnerMerchantOfferRecord> findByStateFlag(String stateFlag);
}
