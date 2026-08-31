package com.neobank.fintech;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class InstantSettlementBridgeNodeServiceImpl implements InstantSettlementBridgeNodeService {
    private final InstantSettlementBridgeNodeRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<InstantSettlementBridgeNodeDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public InstantSettlementBridgeNodeDto create(InstantSettlementBridgeNodeDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        InstantSettlementBridgeNode entity = InstantSettlementBridgeNode.builder().user(u).institutionalRef(dto.getInstitutionalRef() != null ? dto.getInstitutionalRef() : UUID.randomUUID().toString()).executionStatus(dto.getExecutionStatus() != null ? dto.getExecutionStatus() : "ACTIVE").nominalValuation(dto.getNominalValuation()).baseCurrency(dto.getBaseCurrency() != null ? dto.getBaseCurrency() : "USD").regulatoryDossier(dto.getRegulatoryDossier()).compliant(true).finalizedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public InstantSettlementBridgeNodeDto getByRef(String r) { return repository.findByInstitutionalRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        InstantSettlementBridgeNode entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setExecutionStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<InstantSettlementBridgeNodeDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private InstantSettlementBridgeNodeDto mapToDto(InstantSettlementBridgeNode e) {
        return InstantSettlementBridgeNodeDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).institutionalRef(e.getInstitutionalRef()).executionStatus(e.getExecutionStatus()).nominalValuation(e.getNominalValuation()).baseCurrency(e.getBaseCurrency()).regulatoryDossier(e.getRegulatoryDossier()).compliant(e.isCompliant()).finalizedAt(e.getFinalizedAt()).build();
    }
}
