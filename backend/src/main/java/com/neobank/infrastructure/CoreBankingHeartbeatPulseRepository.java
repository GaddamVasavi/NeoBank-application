package com.neobank.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface CoreBankingHeartbeatPulseRepository extends JpaRepository<CoreBankingHeartbeatPulse, UUID> {
    List<CoreBankingHeartbeatPulse> findByUserId(UUID userId);
    Optional<CoreBankingHeartbeatPulse> findByDossierReference(String ref);
    List<CoreBankingHeartbeatPulse> findByOperationalStatus(String status);
}
