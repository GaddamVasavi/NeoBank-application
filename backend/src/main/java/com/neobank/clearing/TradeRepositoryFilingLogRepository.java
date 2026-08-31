package com.neobank.clearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TradeRepositoryFilingLogRepository extends JpaRepository<TradeRepositoryFilingLog, UUID> {
    List<TradeRepositoryFilingLog> findByUserId(UUID userId);
    Optional<TradeRepositoryFilingLog> findByInstitutionalRef(String ref);
    List<TradeRepositoryFilingLog> findByExecutionStatus(String status);
}
