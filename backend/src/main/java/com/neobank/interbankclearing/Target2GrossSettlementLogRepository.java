package com.neobank.interbankclearing;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface Target2GrossSettlementLogRepository extends JpaRepository<Target2GrossSettlementLog, UUID> {
    List<Target2GrossSettlementLog> findByUserId(UUID userId);
    Optional<Target2GrossSettlementLog> findByProtocolReference(String ref);
    List<Target2GrossSettlementLog> findByOperationalState(String state);
}
