package com.neobank.derivatives;
import java.util.List; import java.util.UUID;
public interface CreditDefaultSwapContractService {
    List<CreditDefaultSwapContractDto> getByUser(UUID userId);
    CreditDefaultSwapContractDto create(CreditDefaultSwapContractDto dto);
    CreditDefaultSwapContractDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<CreditDefaultSwapContractDto> listAll();
}
