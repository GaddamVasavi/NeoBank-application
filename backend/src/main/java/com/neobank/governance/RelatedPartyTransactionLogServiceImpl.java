package com.neobank.governance;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class RelatedPartyTransactionLogServiceImpl implements RelatedPartyTransactionLogService {
    private final RelatedPartyTransactionLogRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<RelatedPartyTransactionLogDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public RelatedPartyTransactionLogDto create(RelatedPartyTransactionLogDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        RelatedPartyTransactionLog entity = RelatedPartyTransactionLog.builder().user(u).institutionalRef(dto.getInstitutionalRef() != null ? dto.getInstitutionalRef() : UUID.randomUUID().toString()).executionStatus(dto.getExecutionStatus() != null ? dto.getExecutionStatus() : "ACTIVE").nominalValuation(dto.getNominalValuation()).baseCurrency(dto.getBaseCurrency() != null ? dto.getBaseCurrency() : "USD").regulatoryDossier(dto.getRegulatoryDossier()).compliant(true).finalizedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public RelatedPartyTransactionLogDto getByRef(String r) { return repository.findByInstitutionalRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        RelatedPartyTransactionLog entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setExecutionStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<RelatedPartyTransactionLogDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private RelatedPartyTransactionLogDto mapToDto(RelatedPartyTransactionLog e) {
        return RelatedPartyTransactionLogDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).institutionalRef(e.getInstitutionalRef()).executionStatus(e.getExecutionStatus()).nominalValuation(e.getNominalValuation()).baseCurrency(e.getBaseCurrency()).regulatoryDossier(e.getRegulatoryDossier()).compliant(e.isCompliant()).finalizedAt(e.getFinalizedAt()).build();
    }
}
