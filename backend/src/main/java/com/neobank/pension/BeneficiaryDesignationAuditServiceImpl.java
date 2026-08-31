package com.neobank.pension;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class BeneficiaryDesignationAuditServiceImpl implements BeneficiaryDesignationAuditService {
    private final BeneficiaryDesignationAuditRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<BeneficiaryDesignationAuditDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public BeneficiaryDesignationAuditDto create(BeneficiaryDesignationAuditDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        BeneficiaryDesignationAudit entity = BeneficiaryDesignationAudit.builder().user(u).settlementRef(dto.getSettlementRef() != null ? dto.getSettlementRef() : UUID.randomUUID().toString()).lifecycleStatus(dto.getLifecycleStatus() != null ? dto.getLifecycleStatus() : "ACTIVE").settlementAmount(dto.getSettlementAmount()).settlementCurrency(dto.getSettlementCurrency() != null ? dto.getSettlementCurrency() : "USD").complianceMemo(dto.getComplianceMemo()).cleared(true).settledAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public BeneficiaryDesignationAuditDto getByRef(String r) { return repository.findBySettlementRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        BeneficiaryDesignationAudit entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setLifecycleStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<BeneficiaryDesignationAuditDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private BeneficiaryDesignationAuditDto mapToDto(BeneficiaryDesignationAudit e) {
        return BeneficiaryDesignationAuditDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).settlementRef(e.getSettlementRef()).lifecycleStatus(e.getLifecycleStatus()).settlementAmount(e.getSettlementAmount()).settlementCurrency(e.getSettlementCurrency()).complianceMemo(e.getComplianceMemo()).cleared(e.isCleared()).settledAt(e.getSettledAt()).build();
    }
}
