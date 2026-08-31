package com.neobank.tax;
import java.util.List; import java.util.UUID;
public interface CrossBorderTaxTreatyClaimService {
    List<CrossBorderTaxTreatyClaimDto> getByUser(UUID userId);
    CrossBorderTaxTreatyClaimDto create(CrossBorderTaxTreatyClaimDto dto);
    CrossBorderTaxTreatyClaimDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CrossBorderTaxTreatyClaimDto> listAll();
}
