package com.neobank.leasing;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class VehicleFleetLeaseScheduleServiceImpl implements VehicleFleetLeaseScheduleService {
    private final VehicleFleetLeaseScheduleRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<VehicleFleetLeaseScheduleDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public VehicleFleetLeaseScheduleDto create(VehicleFleetLeaseScheduleDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        VehicleFleetLeaseSchedule entity = VehicleFleetLeaseSchedule.builder().user(u).dossierReference(dto.getDossierReference() != null ? dto.getDossierReference() : UUID.randomUUID().toString()).operationalStatus(dto.getOperationalStatus() != null ? dto.getOperationalStatus() : "ACTIVE").financialMetric(dto.getFinancialMetric()).currencyIso(dto.getCurrencyIso() != null ? dto.getCurrencyIso() : "USD").operationalDetails(dto.getOperationalDetails()).activeFlag(true).loggedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public VehicleFleetLeaseScheduleDto getByRef(String r) { return repository.findByDossierReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        VehicleFleetLeaseSchedule entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setOperationalStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<VehicleFleetLeaseScheduleDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private VehicleFleetLeaseScheduleDto mapToDto(VehicleFleetLeaseSchedule e) {
        return VehicleFleetLeaseScheduleDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).dossierReference(e.getDossierReference()).operationalStatus(e.getOperationalStatus()).financialMetric(e.getFinancialMetric()).currencyIso(e.getCurrencyIso()).operationalDetails(e.getOperationalDetails()).activeFlag(e.isActiveFlag()).loggedAt(e.getLoggedAt()).build();
    }
}
