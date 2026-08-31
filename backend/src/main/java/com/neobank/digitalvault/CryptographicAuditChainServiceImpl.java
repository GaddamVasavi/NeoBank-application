package com.neobank.digitalvault;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class CryptographicAuditChainServiceImpl implements CryptographicAuditChainService {
    private final CryptographicAuditChainRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<CryptographicAuditChainDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public CryptographicAuditChainDto create(CryptographicAuditChainDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        CryptographicAuditChain entity = CryptographicAuditChain.builder().user(u).protocolReference(dto.getProtocolReference() != null ? dto.getProtocolReference() : UUID.randomUUID().toString()).operationalState(dto.getOperationalState() != null ? dto.getOperationalState() : "ACTIVE").notionalMetric(dto.getNotionalMetric()).isoCurrency(dto.getIsoCurrency() != null ? dto.getIsoCurrency() : "USD").narrativeSummary(dto.getNarrativeSummary()).activeRecord(true).timestampExecuted(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public CryptographicAuditChainDto getByRef(String r) { return repository.findByProtocolReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateState(UUID id, String s) {
        CryptographicAuditChain entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setOperationalState(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<CryptographicAuditChainDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private CryptographicAuditChainDto mapToDto(CryptographicAuditChain e) {
        return CryptographicAuditChainDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).protocolReference(e.getProtocolReference()).operationalState(e.getOperationalState()).notionalMetric(e.getNotionalMetric()).isoCurrency(e.getIsoCurrency()).narrativeSummary(e.getNarrativeSummary()).activeRecord(e.isActiveRecord()).timestampExecuted(e.getTimestampExecuted()).build();
    }
}
