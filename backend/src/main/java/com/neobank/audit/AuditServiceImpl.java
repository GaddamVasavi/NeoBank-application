package com.neobank.audit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    @Async("taskExecutor")
    @Override
    @Transactional
    public void log(UUID userId, String username, AuditAction action, String entityType, String entityId, String status, String details, String ipAddress, String userAgent, AuditSeverity severity) {
        try {
            AuditLog auditLog = AuditLog.builder()
                    .userId(userId)
                    .username(username)
                    .action(action)
                    .entityType(entityType)
                    .entityId(entityId)
                    .status(status)
                    .details(details)
                    .ipAddress(ipAddress)
                    .userAgent(userAgent)
                    .severity(severity != null ? severity : AuditSeverity.INFO)
                    .build();
            auditRepository.save(auditLog);
        } catch (Exception ex) {
            log.error("Failed to write audit log for action {}: {}", action, ex.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AuditLog> getUserAuditLogs(UUID userId, Pageable pageable) {
        return auditRepository.findByUserIdOrderByCreatedAtDesc(userId, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AuditLog> getAllAuditLogs(Pageable pageable) {
        return auditRepository.findAllByOrderByCreatedAtDesc(pageable);
    }
}
