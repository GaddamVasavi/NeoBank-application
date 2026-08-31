package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface InvoiceDiscountingFacilityService {
    List<InvoiceDiscountingFacilityDto> getByUser(UUID userId);
    InvoiceDiscountingFacilityDto create(InvoiceDiscountingFacilityDto dto);
    InvoiceDiscountingFacilityDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<InvoiceDiscountingFacilityDto> listAll();
}
