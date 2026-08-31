package com.neobank.merchant;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class VirtualTerminalTransactionServiceImpl implements VirtualTerminalTransactionService {
    private final VirtualTerminalTransactionRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<VirtualTerminalTransactionDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public VirtualTerminalTransactionDto create(VirtualTerminalTransactionDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        VirtualTerminalTransaction entity = VirtualTerminalTransaction.builder().user(u).coreReference(dto.getCoreReference() != null ? dto.getCoreReference() : UUID.randomUUID().toString()).processingStatus(dto.getProcessingStatus() != null ? dto.getProcessingStatus() : "ACTIVE").certifiedValue(dto.getCertifiedValue()).isoCurrency(dto.getIsoCurrency() != null ? dto.getIsoCurrency() : "USD").complianceDossier(dto.getComplianceDossier()).audited(true).certifiedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public VirtualTerminalTransactionDto getByRef(String r) { return repository.findByCoreReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        VirtualTerminalTransaction entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setProcessingStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<VirtualTerminalTransactionDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private VirtualTerminalTransactionDto mapToDto(VirtualTerminalTransaction e) {
        return VirtualTerminalTransactionDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).coreReference(e.getCoreReference()).processingStatus(e.getProcessingStatus()).certifiedValue(e.getCertifiedValue()).isoCurrency(e.getIsoCurrency()).complianceDossier(e.getComplianceDossier()).audited(e.isAudited()).certifiedAt(e.getCertifiedAt()).build();
    }
}
