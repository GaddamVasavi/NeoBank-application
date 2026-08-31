package com.neobank.analyticsengine;
import java.util.List; import java.util.UUID;
public interface ExpectedCreditLossModelService {
    List<ExpectedCreditLossModelDto> getByUser(UUID userId);
    ExpectedCreditLossModelDto create(ExpectedCreditLossModelDto dto);
    ExpectedCreditLossModelDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ExpectedCreditLossModelDto> listAll();
}
