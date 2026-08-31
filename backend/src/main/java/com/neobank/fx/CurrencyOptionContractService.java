package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface CurrencyOptionContractService {
    List<CurrencyOptionContractDto> getByUser(UUID userId);
    CurrencyOptionContractDto create(CurrencyOptionContractDto dto);
    CurrencyOptionContractDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CurrencyOptionContractDto> listAll();
}
