package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface TppClientRegistrationService {
    List<TppClientRegistrationDto> getByUser(UUID userId);
    TppClientRegistrationDto create(TppClientRegistrationDto dto);
    TppClientRegistrationDto getByCode(String code);
    void updateState(UUID id, String state);
    List<TppClientRegistrationDto> listAll();
}
