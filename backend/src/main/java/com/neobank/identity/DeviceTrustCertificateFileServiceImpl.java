package com.neobank.identity;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class DeviceTrustCertificateFileServiceImpl implements DeviceTrustCertificateFileService {
    private final DeviceTrustCertificateFileRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<DeviceTrustCertificateFileDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public DeviceTrustCertificateFileDto create(DeviceTrustCertificateFileDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        DeviceTrustCertificateFile entity = DeviceTrustCertificateFile.builder().user(u).registryKey(dto.getRegistryKey() != null ? dto.getRegistryKey() : UUID.randomUUID().toString()).deliveryStatus(dto.getDeliveryStatus() != null ? dto.getDeliveryStatus() : "ACTIVE").numericReading(dto.getNumericReading()).currencySymbol(dto.getCurrencySymbol() != null ? dto.getCurrencySymbol() : "USD").logPayload(dto.getLogPayload()).activeStatus(true).timestampLogged(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public DeviceTrustCertificateFileDto getByKey(String k) { return repository.findByRegistryKey(k).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        DeviceTrustCertificateFile entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setDeliveryStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<DeviceTrustCertificateFileDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private DeviceTrustCertificateFileDto mapToDto(DeviceTrustCertificateFile e) {
        return DeviceTrustCertificateFileDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).registryKey(e.getRegistryKey()).deliveryStatus(e.getDeliveryStatus()).numericReading(e.getNumericReading()).currencySymbol(e.getCurrencySymbol()).logPayload(e.getLogPayload()).activeStatus(e.isActiveStatus()).timestampLogged(e.getTimestampLogged()).build();
    }
}
