package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface PrivateBankingClientService {
    List<PrivateBankingClientDto> getByUser(UUID userId);
    PrivateBankingClientDto create(PrivateBankingClientDto dto);
    PrivateBankingClientDto getByCode(String code);
    void updateState(UUID id, String state);
    List<PrivateBankingClientDto> listAll();
}
