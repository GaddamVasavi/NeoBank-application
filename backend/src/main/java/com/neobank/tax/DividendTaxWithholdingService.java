package com.neobank.tax;
import java.util.List; import java.util.UUID;
public interface DividendTaxWithholdingService {
    List<DividendTaxWithholdingDto> getByUser(UUID userId);
    DividendTaxWithholdingDto create(DividendTaxWithholdingDto dto);
    DividendTaxWithholdingDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DividendTaxWithholdingDto> listAll();
}
