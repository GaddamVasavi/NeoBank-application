package com.neobank.settlement;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class Target2PaymentInstructionServiceImpl implements Target2PaymentInstructionService {
    private final Target2PaymentInstructionRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<Target2PaymentInstructionDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public Target2PaymentInstructionDto create(Target2PaymentInstructionDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        Target2PaymentInstruction entity = Target2PaymentInstruction.builder().user(u).settlementRef(dto.getSettlementRef() != null ? dto.getSettlementRef() : UUID.randomUUID().toString()).lifecycleStatus(dto.getLifecycleStatus() != null ? dto.getLifecycleStatus() : "ACTIVE").settlementAmount(dto.getSettlementAmount()).settlementCurrency(dto.getSettlementCurrency() != null ? dto.getSettlementCurrency() : "USD").complianceMemo(dto.getComplianceMemo()).cleared(true).settledAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public Target2PaymentInstructionDto getByRef(String r) { return repository.findBySettlementRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        Target2PaymentInstruction entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setLifecycleStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<Target2PaymentInstructionDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private Target2PaymentInstructionDto mapToDto(Target2PaymentInstruction e) {
        return Target2PaymentInstructionDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).settlementRef(e.getSettlementRef()).lifecycleStatus(e.getLifecycleStatus()).settlementAmount(e.getSettlementAmount()).settlementCurrency(e.getSettlementCurrency()).complianceMemo(e.getComplianceMemo()).cleared(e.isCleared()).settledAt(e.getSettledAt()).build();
    }
}
