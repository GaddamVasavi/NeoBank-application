package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface EquipmentLeaseAgreementService {
    List<EquipmentLeaseAgreementDto> getByUser(UUID userId);
    EquipmentLeaseAgreementDto create(EquipmentLeaseAgreementDto dto);
    EquipmentLeaseAgreementDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<EquipmentLeaseAgreementDto> listAll();
}
