package com.neobank.commercial;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class CommercialEscrowAgreementServiceImpl implements CommercialEscrowAgreementService {
    private final CommercialEscrowAgreementRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<CommercialEscrowAgreementDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public CommercialEscrowAgreementDto create(CommercialEscrowAgreementDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        CommercialEscrowAgreement entity = CommercialEscrowAgreement.builder().user(u).identifierCode(dto.getIdentifierCode() != null ? dto.getIdentifierCode() : UUID.randomUUID().toString()).status(dto.getStatus() != null ? dto.getStatus() : "ACTIVE").nominalAmount(dto.getNominalAmount()).currency(dto.getCurrency() != null ? dto.getCurrency() : "USD").specificationNotes(dto.getSpecificationNotes()).active(true).executedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public CommercialEscrowAgreementDto getByCode(String c) { return repository.findByIdentifierCode(c).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        CommercialEscrowAgreement entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<CommercialEscrowAgreementDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private CommercialEscrowAgreementDto mapToDto(CommercialEscrowAgreement e) {
        return CommercialEscrowAgreementDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).identifierCode(e.getIdentifierCode()).status(e.getStatus()).nominalAmount(e.getNominalAmount()).currency(e.getCurrency()).specificationNotes(e.getSpecificationNotes()).active(e.isActive()).executedAt(e.getExecutedAt()).build();
    }
}
