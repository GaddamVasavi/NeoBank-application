package com.neobank.governance;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface InsiderTradingRegistryRepository extends JpaRepository<InsiderTradingRegistry, UUID> {
    List<InsiderTradingRegistry> findByUserId(UUID userId);
    Optional<InsiderTradingRegistry> findByInstitutionalRef(String ref);
    List<InsiderTradingRegistry> findByExecutionStatus(String status);
}
