package com.neobank.regulatory;
import java.util.List; import java.util.UUID;
public interface CapitalAdequacyReturnService {
    List<CapitalAdequacyReturnDto> getByUser(UUID userId);
    CapitalAdequacyReturnDto create(CapitalAdequacyReturnDto dto);
    CapitalAdequacyReturnDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CapitalAdequacyReturnDto> listAll();
}
