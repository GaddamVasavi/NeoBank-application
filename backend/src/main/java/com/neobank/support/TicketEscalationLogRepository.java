package com.neobank.support;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface TicketEscalationLogRepository extends JpaRepository<TicketEscalationLog, UUID> {
    List<TicketEscalationLog> findByUserId(UUID userId);
    Optional<TicketEscalationLog> findByRecordKey(String recordKey);
    List<TicketEscalationLog> findByStatus(String status);
}
