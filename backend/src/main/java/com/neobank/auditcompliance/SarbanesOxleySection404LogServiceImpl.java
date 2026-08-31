package com.neobank.auditcompliance;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class SarbanesOxleySection404LogServiceImpl implements SarbanesOxleySection404LogService {
    private final SarbanesOxleySection404LogRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<SarbanesOxleySection404LogDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public SarbanesOxleySection404LogDto create(SarbanesOxleySection404LogDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        SarbanesOxleySection404Log entity = SarbanesOxleySection404Log.builder().user(u).clearingKey(dto.getClearingKey() != null ? dto.getClearingKey() : UUID.randomUUID().toString()).auditStatus(dto.getAuditStatus() != null ? dto.getAuditStatus() : "ACTIVE").principalValuation(dto.getPrincipalValuation()).baseIsoCode(dto.getBaseIsoCode() != null ? dto.getBaseIsoCode() : "USD").executiveMemo(dto.getExecutiveMemo()).reconciled(true).reconciledAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public SarbanesOxleySection404LogDto getByKey(String k) { return repository.findByClearingKey(k).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        SarbanesOxleySection404Log entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setAuditStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<SarbanesOxleySection404LogDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private SarbanesOxleySection404LogDto mapToDto(SarbanesOxleySection404Log e) {
        return SarbanesOxleySection404LogDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).clearingKey(e.getClearingKey()).auditStatus(e.getAuditStatus()).principalValuation(e.getPrincipalValuation()).baseIsoCode(e.getBaseIsoCode()).executiveMemo(e.getExecutiveMemo()).reconciled(e.isReconciled()).reconciledAt(e.getReconciledAt()).build();
    }
}
