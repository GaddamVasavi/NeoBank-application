package com.neobank.risk;
import java.util.List; import java.util.UUID;
public interface CreditRiskDefaultModelService {
    List<CreditRiskDefaultModelDto> getByUser(UUID userId);
    CreditRiskDefaultModelDto create(CreditRiskDefaultModelDto dto);
    CreditRiskDefaultModelDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CreditRiskDefaultModelDto> listAll();
}
