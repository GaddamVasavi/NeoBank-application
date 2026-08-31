package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface CorporateExpenseClaimService {
    List<CorporateExpenseClaimDto> getByUser(UUID userId);
    CorporateExpenseClaimDto create(CorporateExpenseClaimDto dto);
    CorporateExpenseClaimDto getByCode(String code);
    void updateState(UUID id, String state);
    List<CorporateExpenseClaimDto> listAll();
}
