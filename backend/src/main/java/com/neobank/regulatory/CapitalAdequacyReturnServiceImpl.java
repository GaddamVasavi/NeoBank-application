package com.neobank.regulatory;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class CapitalAdequacyReturnServiceImpl implements CapitalAdequacyReturnService {
    private final CapitalAdequacyReturnRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<CapitalAdequacyReturnDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public CapitalAdequacyReturnDto create(CapitalAdequacyReturnDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        CapitalAdequacyReturn entity = CapitalAdequacyReturn.builder().user(u).authorityRef(dto.getAuthorityRef() != null ? dto.getAuthorityRef() : UUID.randomUUID().toString()).submissionStatus(dto.getSubmissionStatus() != null ? dto.getSubmissionStatus() : "ACTIVE").reportedAmount(dto.getReportedAmount()).reportingCurrency(dto.getReportingCurrency() != null ? dto.getReportingCurrency() : "USD").regulatoryNotes(dto.getRegulatoryNotes()).filed(true).filedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public CapitalAdequacyReturnDto getByRef(String r) { return repository.findByAuthorityRef(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        CapitalAdequacyReturn entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setSubmissionStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<CapitalAdequacyReturnDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private CapitalAdequacyReturnDto mapToDto(CapitalAdequacyReturn e) {
        return CapitalAdequacyReturnDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).authorityRef(e.getAuthorityRef()).submissionStatus(e.getSubmissionStatus()).reportedAmount(e.getReportedAmount()).reportingCurrency(e.getReportingCurrency()).regulatoryNotes(e.getRegulatoryNotes()).filed(e.isFiled()).filedAt(e.getFiledAt()).build();
    }
}
