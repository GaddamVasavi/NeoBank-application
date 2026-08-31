package com.neobank.clearing;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class PositionLimitMonitoringLogServiceImpl implements PositionLimitMonitoringLogService {
    private final PositionLimitMonitoringLogRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<PositionLimitMonitoringLogDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public PositionLimitMonitoringLogDto create(PositionLimitMonitoringLogDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        PositionLimitMonitoringLog entity = PositionLimitMonitoringLog.builder().user(u).institutionalRef(dto.getInstitutionalRef() != null ? dto.getInstitutionalRef() : UUID.randomUUID().toString()).executionStatus(dto.getExecutionStatus() != null ? dto.getExecutionStatus() : "ACTIVE").nominalValuation(dto.getNominalValuation()).baseCurrency(dto.getBaseCurrency() != null ? dto.getBaseCurrency() : "USD").regulatoryDossier(dto.getRegulatoryDossier()).compliant(true).finalizedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public PositionLimitMonitoringLogDto getByRef(String r) { return repository.findByInstitutionalRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        PositionLimitMonitoringLog entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setExecutionStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<PositionLimitMonitoringLogDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private PositionLimitMonitoringLogDto mapToDto(PositionLimitMonitoringLog e) {
        return PositionLimitMonitoringLogDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).institutionalRef(e.getInstitutionalRef()).executionStatus(e.getExecutionStatus()).nominalValuation(e.getNominalValuation()).baseCurrency(e.getBaseCurrency()).regulatoryDossier(e.getRegulatoryDossier()).compliant(e.isCompliant()).finalizedAt(e.getFinalizedAt()).build();
    }
}
