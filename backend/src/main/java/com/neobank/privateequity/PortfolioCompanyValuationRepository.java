package com.neobank.privateequity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PortfolioCompanyValuationRepository extends JpaRepository<PortfolioCompanyValuation, UUID> {
    List<PortfolioCompanyValuation> findByUserId(UUID userId);
    Optional<PortfolioCompanyValuation> findByProtocolReference(String ref);
    List<PortfolioCompanyValuation> findByOperationalState(String state);
}
