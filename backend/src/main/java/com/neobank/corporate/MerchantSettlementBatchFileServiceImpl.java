package com.neobank.corporate;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class MerchantSettlementBatchFileServiceImpl implements MerchantSettlementBatchFileService {
    private final MerchantSettlementBatchFileRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<MerchantSettlementBatchFileDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public MerchantSettlementBatchFileDto create(MerchantSettlementBatchFileDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        MerchantSettlementBatchFile entity = MerchantSettlementBatchFile.builder().user(u).trackingCode(dto.getTrackingCode() != null ? dto.getTrackingCode() : UUID.randomUUID().toString()).stateFlag(dto.getStateFlag() != null ? dto.getStateFlag() : "ACTIVE").evaluationAmount(dto.getEvaluationAmount()).denomination(dto.getDenomination() != null ? dto.getDenomination() : "USD").auditNarrative(dto.getAuditNarrative()).enabled(true).creationTimestamp(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public MerchantSettlementBatchFileDto getByCode(String c) { return repository.findByTrackingCode(c).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateState(UUID id, String s) {
        MerchantSettlementBatchFile entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setStateFlag(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<MerchantSettlementBatchFileDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private MerchantSettlementBatchFileDto mapToDto(MerchantSettlementBatchFile e) {
        return MerchantSettlementBatchFileDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).trackingCode(e.getTrackingCode()).stateFlag(e.getStateFlag()).evaluationAmount(e.getEvaluationAmount()).denomination(e.getDenomination()).auditNarrative(e.getAuditNarrative()).enabled(e.isEnabled()).creationTimestamp(e.getCreationTimestamp()).build();
    }
}
