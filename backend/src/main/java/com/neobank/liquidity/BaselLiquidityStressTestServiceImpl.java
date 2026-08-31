package com.neobank.liquidity;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class BaselLiquidityStressTestServiceImpl implements BaselLiquidityStressTestService {
    private final BaselLiquidityStressTestRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<BaselLiquidityStressTestDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public BaselLiquidityStressTestDto create(BaselLiquidityStressTestDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        BaselLiquidityStressTest entity = BaselLiquidityStressTest.builder().user(u).systemIdentifier(dto.getSystemIdentifier() != null ? dto.getSystemIdentifier() : UUID.randomUUID().toString()).validationState(dto.getValidationState() != null ? dto.getValidationState() : "ACTIVE").marketValuation(dto.getMarketValuation()).currencyCode(dto.getCurrencyCode() != null ? dto.getCurrencyCode() : "USD").narrativeNotes(dto.getNarrativeNotes()).verified(true).recordedTimestamp(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public BaselLiquidityStressTestDto getByIdentifier(String i) { return repository.findBySystemIdentifier(i).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateState(UUID id, String s) {
        BaselLiquidityStressTest entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setValidationState(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<BaselLiquidityStressTestDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private BaselLiquidityStressTestDto mapToDto(BaselLiquidityStressTest e) {
        return BaselLiquidityStressTestDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).systemIdentifier(e.getSystemIdentifier()).validationState(e.getValidationState()).marketValuation(e.getMarketValuation()).currencyCode(e.getCurrencyCode()).narrativeNotes(e.getNarrativeNotes()).verified(e.isVerified()).recordedTimestamp(e.getRecordedTimestamp()).build();
    }
}
