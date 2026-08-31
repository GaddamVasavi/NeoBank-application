package com.neobank.pension;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class LifeInsurancePolicyWrapperServiceImpl implements LifeInsurancePolicyWrapperService {
    private final LifeInsurancePolicyWrapperRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<LifeInsurancePolicyWrapperDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public LifeInsurancePolicyWrapperDto create(LifeInsurancePolicyWrapperDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        LifeInsurancePolicyWrapper entity = LifeInsurancePolicyWrapper.builder().user(u).settlementRef(dto.getSettlementRef() != null ? dto.getSettlementRef() : UUID.randomUUID().toString()).lifecycleStatus(dto.getLifecycleStatus() != null ? dto.getLifecycleStatus() : "ACTIVE").settlementAmount(dto.getSettlementAmount()).settlementCurrency(dto.getSettlementCurrency() != null ? dto.getSettlementCurrency() : "USD").complianceMemo(dto.getComplianceMemo()).cleared(true).settledAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public LifeInsurancePolicyWrapperDto getByRef(String r) { return repository.findBySettlementRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        LifeInsurancePolicyWrapper entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setLifecycleStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<LifeInsurancePolicyWrapperDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private LifeInsurancePolicyWrapperDto mapToDto(LifeInsurancePolicyWrapper e) {
        return LifeInsurancePolicyWrapperDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).settlementRef(e.getSettlementRef()).lifecycleStatus(e.getLifecycleStatus()).settlementAmount(e.getSettlementAmount()).settlementCurrency(e.getSettlementCurrency()).complianceMemo(e.getComplianceMemo()).cleared(e.isCleared()).settledAt(e.getSettledAt()).build();
    }
}
