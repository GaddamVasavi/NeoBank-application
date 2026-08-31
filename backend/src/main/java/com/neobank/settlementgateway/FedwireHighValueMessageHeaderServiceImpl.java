package com.neobank.settlementgateway;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class FedwireHighValueMessageHeaderServiceImpl implements FedwireHighValueMessageHeaderService {
    private final FedwireHighValueMessageHeaderRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<FedwireHighValueMessageHeaderDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public FedwireHighValueMessageHeaderDto create(FedwireHighValueMessageHeaderDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        FedwireHighValueMessageHeader entity = FedwireHighValueMessageHeader.builder().user(u).gatewayReference(dto.getGatewayReference() != null ? dto.getGatewayReference() : UUID.randomUUID().toString()).settlementState(dto.getSettlementState() != null ? dto.getSettlementState() : "ACTIVE").settledValuation(dto.getSettledValuation()).currencyIso(dto.getCurrencyIso() != null ? dto.getCurrencyIso() : "USD").auditDossier(dto.getAuditDossier()).finalized(true).finalizedTimestamp(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public FedwireHighValueMessageHeaderDto getByRef(String r) { return repository.findByGatewayReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateState(UUID id, String s) {
        FedwireHighValueMessageHeader entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setSettlementState(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<FedwireHighValueMessageHeaderDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private FedwireHighValueMessageHeaderDto mapToDto(FedwireHighValueMessageHeader e) {
        return FedwireHighValueMessageHeaderDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).gatewayReference(e.getGatewayReference()).settlementState(e.getSettlementState()).settledValuation(e.getSettledValuation()).currencyIso(e.getCurrencyIso()).auditDossier(e.getAuditDossier()).finalized(e.isFinalized()).finalizedTimestamp(e.getFinalizedTimestamp()).build();
    }
}
