package com.neobank.settlementgateway;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class InterbankLiquiditySwapLogServiceImpl implements InterbankLiquiditySwapLogService {
    private final InterbankLiquiditySwapLogRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<InterbankLiquiditySwapLogDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public InterbankLiquiditySwapLogDto create(InterbankLiquiditySwapLogDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        InterbankLiquiditySwapLog entity = InterbankLiquiditySwapLog.builder().user(u).gatewayReference(dto.getGatewayReference() != null ? dto.getGatewayReference() : UUID.randomUUID().toString()).settlementState(dto.getSettlementState() != null ? dto.getSettlementState() : "ACTIVE").settledValuation(dto.getSettledValuation()).currencyIso(dto.getCurrencyIso() != null ? dto.getCurrencyIso() : "USD").auditDossier(dto.getAuditDossier()).finalized(true).finalizedTimestamp(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public InterbankLiquiditySwapLogDto getByRef(String r) { return repository.findByGatewayReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateState(UUID id, String s) {
        InterbankLiquiditySwapLog entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setSettlementState(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<InterbankLiquiditySwapLogDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private InterbankLiquiditySwapLogDto mapToDto(InterbankLiquiditySwapLog e) {
        return InterbankLiquiditySwapLogDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).gatewayReference(e.getGatewayReference()).settlementState(e.getSettlementState()).settledValuation(e.getSettledValuation()).currencyIso(e.getCurrencyIso()).auditDossier(e.getAuditDossier()).finalized(e.isFinalized()).finalizedTimestamp(e.getFinalizedTimestamp()).build();
    }
}
