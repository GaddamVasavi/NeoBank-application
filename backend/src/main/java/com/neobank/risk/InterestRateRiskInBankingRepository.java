package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InterestRateRiskInBankingRepository extends JpaRepository<InterestRateRiskInBanking, UUID> {
    List<InterestRateRiskInBanking> findByUserId(UUID userId);
    Optional<InterestRateRiskInBanking> findByTrackingCode(String code);
    List<InterestRateRiskInBanking> findByStateFlag(String stateFlag);
}
