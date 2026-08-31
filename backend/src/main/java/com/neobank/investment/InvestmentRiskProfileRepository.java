package com.neobank.investment;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InvestmentRiskProfileRepository extends JpaRepository<InvestmentRiskProfile, UUID> {
    List<InvestmentRiskProfile> findByUserId(UUID userId);
    Optional<InvestmentRiskProfile> findByIdentifierCode(String code);
    List<InvestmentRiskProfile> findByStatus(String status);
}
