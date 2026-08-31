package com.neobank.operations;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface AtmTerminalManagementLogRepository extends JpaRepository<AtmTerminalManagementLog, UUID> {
    List<AtmTerminalManagementLog> findByUserId(UUID userId);
    Optional<AtmTerminalManagementLog> findByTrackingCode(String code);
    List<AtmTerminalManagementLog> findByStateFlag(String stateFlag);
}
