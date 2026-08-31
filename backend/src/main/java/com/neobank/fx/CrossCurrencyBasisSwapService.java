package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface CrossCurrencyBasisSwapService {
    List<CrossCurrencyBasisSwapDto> getByUser(UUID userId);
    CrossCurrencyBasisSwapDto create(CrossCurrencyBasisSwapDto dto);
    CrossCurrencyBasisSwapDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CrossCurrencyBasisSwapDto> listAll();
}
