package com.neobank.tax;
import java.util.List; import java.util.UUID;
public interface TaxForm1099IntGenerationService {
    List<TaxForm1099IntGenerationDto> getByUser(UUID userId);
    TaxForm1099IntGenerationDto create(TaxForm1099IntGenerationDto dto);
    TaxForm1099IntGenerationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<TaxForm1099IntGenerationDto> listAll();
}
