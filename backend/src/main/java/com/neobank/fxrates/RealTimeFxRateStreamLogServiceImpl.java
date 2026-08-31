package com.neobank.fxrates;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class RealTimeFxRateStreamLogServiceImpl implements RealTimeFxRateStreamLogService {
    private final RealTimeFxRateStreamLogRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<RealTimeFxRateStreamLogDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public RealTimeFxRateStreamLogDto create(RealTimeFxRateStreamLogDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        RealTimeFxRateStreamLog entity = RealTimeFxRateStreamLog.builder().user(u).registryKey(dto.getRegistryKey() != null ? dto.getRegistryKey() : UUID.randomUUID().toString()).deliveryStatus(dto.getDeliveryStatus() != null ? dto.getDeliveryStatus() : "ACTIVE").numericReading(dto.getNumericReading()).currencySymbol(dto.getCurrencySymbol() != null ? dto.getCurrencySymbol() : "USD").logPayload(dto.getLogPayload()).activeStatus(true).timestampLogged(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public RealTimeFxRateStreamLogDto getByKey(String k) { return repository.findByRegistryKey(k).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        RealTimeFxRateStreamLog entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setDeliveryStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<RealTimeFxRateStreamLogDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private RealTimeFxRateStreamLogDto mapToDto(RealTimeFxRateStreamLog e) {
        return RealTimeFxRateStreamLogDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).registryKey(e.getRegistryKey()).deliveryStatus(e.getDeliveryStatus()).numericReading(e.getNumericReading()).currencySymbol(e.getCurrencySymbol()).logPayload(e.getLogPayload()).activeStatus(e.isActiveStatus()).timestampLogged(e.getTimestampLogged()).build();
    }
}
