package com.neobank.analyticsengine;
import java.util.List; import java.util.UUID;
public interface DepositBetaSensitivityService {
    List<DepositBetaSensitivityDto> getByUser(UUID userId);
    DepositBetaSensitivityDto create(DepositBetaSensitivityDto dto);
    DepositBetaSensitivityDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DepositBetaSensitivityDto> listAll();
}
