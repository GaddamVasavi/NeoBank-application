package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PortfolioMarginingRuleModelRepository extends JpaRepository<PortfolioMarginingRuleModel, UUID> {
    List<PortfolioMarginingRuleModel> findByUserId(UUID userId);
    Optional<PortfolioMarginingRuleModel> findByInstitutionalRef(String ref);
    List<PortfolioMarginingRuleModel> findByExecutionStatus(String status);
}
