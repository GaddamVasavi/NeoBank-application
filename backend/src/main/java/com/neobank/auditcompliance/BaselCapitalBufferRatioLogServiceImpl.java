package com.neobank.auditcompliance;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class BaselCapitalBufferRatioLogServiceImpl implements BaselCapitalBufferRatioLogService {
    private final BaselCapitalBufferRatioLogRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<BaselCapitalBufferRatioLogDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public BaselCapitalBufferRatioLogDto create(BaselCapitalBufferRatioLogDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        BaselCapitalBufferRatioLog entity = BaselCapitalBufferRatioLog.builder().user(u).clearingKey(dto.getClearingKey() != null ? dto.getClearingKey() : UUID.randomUUID().toString()).auditStatus(dto.getAuditStatus() != null ? dto.getAuditStatus() : "ACTIVE").principalValuation(dto.getPrincipalValuation()).baseIsoCode(dto.getBaseIsoCode() != null ? dto.getBaseIsoCode() : "USD").executiveMemo(dto.getExecutiveMemo()).reconciled(true).reconciledAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public BaselCapitalBufferRatioLogDto getByKey(String k) { return repository.findByClearingKey(k).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        BaselCapitalBufferRatioLog entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setAuditStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<BaselCapitalBufferRatioLogDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private BaselCapitalBufferRatioLogDto mapToDto(BaselCapitalBufferRatioLog e) {
        return BaselCapitalBufferRatioLogDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).clearingKey(e.getClearingKey()).auditStatus(e.getAuditStatus()).principalValuation(e.getPrincipalValuation()).baseIsoCode(e.getBaseIsoCode()).executiveMemo(e.getExecutiveMemo()).reconciled(e.isReconciled()).reconciledAt(e.getReconciledAt()).build();
    }
}
