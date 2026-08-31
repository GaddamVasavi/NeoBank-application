package com.finverse.carboncredits;

import com.finverse.common.ResourceNotFoundException;
import com.finverse.common.TenantContext;
import com.finverse.users.User;
import com.finverse.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Transactional Service Implementation for Scope3FinancedEmissions
 */
@Service
@RequiredArgsConstructor
public class Scope3FinancedEmissionsServiceImpl implements Scope3FinancedEmissionsService {
    private final Scope3FinancedEmissionsRepository repository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Scope3FinancedEmissionsDto> getByTenant(UUID tenantId) {
        return repository.findByTenantId(tenantId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Scope3FinancedEmissionsDto> getByUser(UUID userId) {
        return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Scope3FinancedEmissionsDto create(Scope3FinancedEmissionsDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        UUID tId = dto.getTenantId() != null ? dto.getTenantId() : (TenantContext.getTenantId() != null ? TenantContext.getTenantId() : UUID.randomUUID());
        Scope3FinancedEmissions entity = Scope3FinancedEmissions.builder()
            .user(u)
            .systemReference(dto.getSystemReference() != null ? dto.getSystemReference() : UUID.randomUUID().toString())
            .operationalStatus(dto.getOperationalStatus() != null ? dto.getOperationalStatus() : "ACTIVE")
            .certifiedQuantum(dto.getCertifiedQuantum() != null ? dto.getCertifiedQuantum() : BigDecimal.ZERO)
            .isoCurrency(dto.getIsoCurrency() != null ? dto.getIsoCurrency() : "USD")
            .complianceMemo(dto.getComplianceMemo())
            .auditedRecord(true)
            .timestampLogged(Instant.now())
            .build();
        entity.setTenantId(tId);
        return mapToDto(repository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public Scope3FinancedEmissionsDto getByReference(String ref) {
        return repository.findBySystemReference(ref).map(this::mapToDto)
            .orElseThrow(() -> new ResourceNotFoundException("Entity not found: " + ref));
    }

    @Override
    @Transactional
    public void updateStatus(UUID id, String status) {
        Scope3FinancedEmissions entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Entity not found: " + id));
        entity.setOperationalStatus(status);
        repository.save(entity);
    }}

    @Override
    @Transactional(readOnly = true)
    public List<Scope3FinancedEmissionsDto> listAll() {
        return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private Scope3FinancedEmissionsDto mapToDto(Scope3FinancedEmissions e) {
        return Scope3FinancedEmissionsDto.builder()
            .id(e.getId())
            .tenantId(e.getTenantId())
            .userId(e.getUser() != null ? e.getUser().getId() : null)
            .systemReference(e.getSystemReference())
            .operationalStatus(e.getOperationalStatus())
            .certifiedQuantum(e.getCertifiedQuantum())
            .isoCurrency(e.getIsoCurrency())
            .complianceMemo(e.getComplianceMemo())
            .auditedRecord(e.isAuditedRecord())
            .timestampLogged(e.getTimestampLogged())
            .build();
    }
}
