package com.neobank.risk;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CreditRiskDefaultModelRepository extends JpaRepository<CreditRiskDefaultModel, UUID> {
    List<CreditRiskDefaultModel> findByUserId(UUID userId);
    Optional<CreditRiskDefaultModel> findByTrackingCode(String code);
    List<CreditRiskDefaultModel> findByStateFlag(String stateFlag);
}
