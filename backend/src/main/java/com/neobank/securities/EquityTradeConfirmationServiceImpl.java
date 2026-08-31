package com.neobank.securities;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class EquityTradeConfirmationServiceImpl implements EquityTradeConfirmationService {
    private final EquityTradeConfirmationRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<EquityTradeConfirmationDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public EquityTradeConfirmationDto create(EquityTradeConfirmationDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        EquityTradeConfirmation entity = EquityTradeConfirmation.builder().user(u).systemIdentifier(dto.getSystemIdentifier() != null ? dto.getSystemIdentifier() : UUID.randomUUID().toString()).validationState(dto.getValidationState() != null ? dto.getValidationState() : "ACTIVE").marketValuation(dto.getMarketValuation()).currencyCode(dto.getCurrencyCode() != null ? dto.getCurrencyCode() : "USD").narrativeNotes(dto.getNarrativeNotes()).verified(true).recordedTimestamp(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public EquityTradeConfirmationDto getByIdentifier(String i) { return repository.findBySystemIdentifier(i).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateState(UUID id, String s) {
        EquityTradeConfirmation entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setValidationState(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<EquityTradeConfirmationDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private EquityTradeConfirmationDto mapToDto(EquityTradeConfirmation e) {
        return EquityTradeConfirmationDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).systemIdentifier(e.getSystemIdentifier()).validationState(e.getValidationState()).marketValuation(e.getMarketValuation()).currencyCode(e.getCurrencyCode()).narrativeNotes(e.getNarrativeNotes()).verified(e.isVerified()).recordedTimestamp(e.getRecordedTimestamp()).build();
    }
}
