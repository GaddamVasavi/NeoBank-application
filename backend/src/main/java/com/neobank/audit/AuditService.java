package com.neobank.audit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;
public interface AuditService {
    void log(UUID userId, String username, AuditAction action, String entityType, String entityId, String status, String details, String ipAddress, String userAgent, AuditSeverity severity);
    Page<AuditLog> getUserAuditLogs(UUID userId, Pageable pageable);
    Page<AuditLog> getAllAuditLogs(Pageable pageable);
}
