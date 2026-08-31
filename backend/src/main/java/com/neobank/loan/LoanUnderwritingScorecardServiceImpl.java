package com.neobank.loan;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class LoanUnderwritingScorecardServiceImpl implements LoanUnderwritingScorecardService {
    private final LoanUnderwritingScorecardRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<LoanUnderwritingScorecardDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public LoanUnderwritingScorecardDto create(LoanUnderwritingScorecardDto dto) {
        User u = userRepository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        LoanUnderwritingScorecard entity = LoanUnderwritingScorecard.builder().user(u).codeReference(dto.getCodeReference() != null ? dto.getCodeReference() : UUID.randomUUID().toString()).status("ACTIVE").scoreValue(dto.getScoreValue()).metadataPayload(dto.getMetadataPayload()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public LoanUnderwritingScorecardDto getByRef(String r) { return repository.findByCodeReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        LoanUnderwritingScorecard entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setStatus(status); if ("VERIFIED".equalsIgnoreCase(status) || "RESOLVED".equalsIgnoreCase(status)) entity.setVerifiedAt(Instant.now()); repository.save(entity);
    }
    private LoanUnderwritingScorecardDto mapToDto(LoanUnderwritingScorecard e) {
        return LoanUnderwritingScorecardDto.builder().id(e.getId()).userId(e.getUser().getId()).codeReference(e.getCodeReference()).status(e.getStatus()).scoreValue(e.getScoreValue()).metadataPayload(e.getMetadataPayload()).verifiedAt(e.getVerifiedAt()).build();
    }
}
