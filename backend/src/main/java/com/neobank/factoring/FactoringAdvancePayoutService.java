package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface FactoringAdvancePayoutService {
    List<FactoringAdvancePayoutDto> getByUser(UUID userId);
    FactoringAdvancePayoutDto create(FactoringAdvancePayoutDto dto);
    FactoringAdvancePayoutDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FactoringAdvancePayoutDto> listAll();
}
