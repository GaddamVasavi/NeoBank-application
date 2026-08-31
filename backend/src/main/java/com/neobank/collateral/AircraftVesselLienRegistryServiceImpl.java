package com.neobank.collateral;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class AircraftVesselLienRegistryServiceImpl implements AircraftVesselLienRegistryService {
    private final AircraftVesselLienRegistryRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<AircraftVesselLienRegistryDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public AircraftVesselLienRegistryDto create(AircraftVesselLienRegistryDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        AircraftVesselLienRegistry entity = AircraftVesselLienRegistry.builder().user(u).coreReference(dto.getCoreReference() != null ? dto.getCoreReference() : UUID.randomUUID().toString()).processingStatus(dto.getProcessingStatus() != null ? dto.getProcessingStatus() : "ACTIVE").certifiedValue(dto.getCertifiedValue()).isoCurrency(dto.getIsoCurrency() != null ? dto.getIsoCurrency() : "USD").complianceDossier(dto.getComplianceDossier()).audited(true).certifiedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public AircraftVesselLienRegistryDto getByRef(String r) { return repository.findByCoreReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        AircraftVesselLienRegistry entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setProcessingStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<AircraftVesselLienRegistryDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private AircraftVesselLienRegistryDto mapToDto(AircraftVesselLienRegistry e) {
        return AircraftVesselLienRegistryDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).coreReference(e.getCoreReference()).processingStatus(e.getProcessingStatus()).certifiedValue(e.getCertifiedValue()).isoCurrency(e.getIsoCurrency()).complianceDossier(e.getComplianceDossier()).audited(e.isAudited()).certifiedAt(e.getCertifiedAt()).build();
    }
}
