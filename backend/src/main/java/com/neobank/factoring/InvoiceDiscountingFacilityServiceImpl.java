package com.neobank.factoring;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class InvoiceDiscountingFacilityServiceImpl implements InvoiceDiscountingFacilityService {
    private final InvoiceDiscountingFacilityRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<InvoiceDiscountingFacilityDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public InvoiceDiscountingFacilityDto create(InvoiceDiscountingFacilityDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        InvoiceDiscountingFacility entity = InvoiceDiscountingFacility.builder().user(u).dossierReference(dto.getDossierReference() != null ? dto.getDossierReference() : UUID.randomUUID().toString()).operationalStatus(dto.getOperationalStatus() != null ? dto.getOperationalStatus() : "ACTIVE").financialMetric(dto.getFinancialMetric()).currencyIso(dto.getCurrencyIso() != null ? dto.getCurrencyIso() : "USD").operationalDetails(dto.getOperationalDetails()).activeFlag(true).loggedAt(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public InvoiceDiscountingFacilityDto getByRef(String r) { return repository.findByDossierReference(r).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        InvoiceDiscountingFacility entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setOperationalStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<InvoiceDiscountingFacilityDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private InvoiceDiscountingFacilityDto mapToDto(InvoiceDiscountingFacility e) {
        return InvoiceDiscountingFacilityDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).dossierReference(e.getDossierReference()).operationalStatus(e.getOperationalStatus()).financialMetric(e.getFinancialMetric()).currencyIso(e.getCurrencyIso()).operationalDetails(e.getOperationalDetails()).activeFlag(e.isActiveFlag()).loggedAt(e.getLoggedAt()).build();
    }
}
