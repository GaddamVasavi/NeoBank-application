package com.neobank.kyc;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface KycRiskCategorizationRepository extends JpaRepository<KycRiskCategorization, UUID> {
    List<KycRiskCategorization> findByUserId(UUID userId);
    Optional<KycRiskCategorization> findByRecordKey(String recordKey);
    List<KycRiskCategorization> findByStatus(String status);
}
