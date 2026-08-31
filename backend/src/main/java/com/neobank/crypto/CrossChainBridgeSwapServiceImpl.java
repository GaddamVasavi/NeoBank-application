package com.neobank.crypto;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class CrossChainBridgeSwapServiceImpl implements CrossChainBridgeSwapService {
    private final CrossChainBridgeSwapRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<CrossChainBridgeSwapDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public CrossChainBridgeSwapDto create(CrossChainBridgeSwapDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        CrossChainBridgeSwap entity = CrossChainBridgeSwap.builder().user(u).authorityRef(dto.getAuthorityRef() != null ? dto.getAuthorityRef() : UUID.randomUUID().toString()).submissionStatus(dto.getSubmissionStatus() != null ? dto.getSubmissionStatus() : "ACTIVE").reportedAmount(dto.getReportedAmount()).reportingCurrency(dto.getReportingCurrency() != null ? dto.getReportingCurrency() : "USD").regulatoryNotes(dto.getRegulatoryNotes()).filed(true).filedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public CrossChainBridgeSwapDto getByRef(String r) { return repository.findByAuthorityRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        CrossChainBridgeSwap entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setSubmissionStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<CrossChainBridgeSwapDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private CrossChainBridgeSwapDto mapToDto(CrossChainBridgeSwap e) {
        return CrossChainBridgeSwapDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).authorityRef(e.getAuthorityRef()).submissionStatus(e.getSubmissionStatus()).reportedAmount(e.getReportedAmount()).reportingCurrency(e.getReportingCurrency()).regulatoryNotes(e.getRegulatoryNotes()).filed(e.isFiled()).filedAt(e.getFiledAt()).build();
    }
}
