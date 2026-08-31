package com.neobank.identity;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class WebAuthnCredentialRecordServiceImpl implements WebAuthnCredentialRecordService {
    private final WebAuthnCredentialRecordRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<WebAuthnCredentialRecordDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public WebAuthnCredentialRecordDto create(WebAuthnCredentialRecordDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        WebAuthnCredentialRecord entity = WebAuthnCredentialRecord.builder().user(u).registryKey(dto.getRegistryKey() != null ? dto.getRegistryKey() : UUID.randomUUID().toString()).deliveryStatus(dto.getDeliveryStatus() != null ? dto.getDeliveryStatus() : "ACTIVE").numericReading(dto.getNumericReading()).currencySymbol(dto.getCurrencySymbol() != null ? dto.getCurrencySymbol() : "USD").logPayload(dto.getLogPayload()).activeStatus(true).timestampLogged(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public WebAuthnCredentialRecordDto getByKey(String k) { return repository.findByRegistryKey(k).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        WebAuthnCredentialRecord entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setDeliveryStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<WebAuthnCredentialRecordDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private WebAuthnCredentialRecordDto mapToDto(WebAuthnCredentialRecord e) {
        return WebAuthnCredentialRecordDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).registryKey(e.getRegistryKey()).deliveryStatus(e.getDeliveryStatus()).numericReading(e.getNumericReading()).currencySymbol(e.getCurrencySymbol()).logPayload(e.getLogPayload()).activeStatus(e.isActiveStatus()).timestampLogged(e.getTimestampLogged()).build();
    }
}
