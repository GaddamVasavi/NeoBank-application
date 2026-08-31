package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface PolicySurrenderValuationService {
    List<PolicySurrenderValuationDto> getByUser(UUID userId);
    PolicySurrenderValuationDto create(PolicySurrenderValuationDto dto);
    PolicySurrenderValuationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<PolicySurrenderValuationDto> listAll();
}
