package com.neobank.wealth;
import java.util.List; import java.util.UUID;
public interface PhilanthropicEndowmentService {
    List<PhilanthropicEndowmentDto> getByUser(UUID userId);
    PhilanthropicEndowmentDto create(PhilanthropicEndowmentDto dto);
    PhilanthropicEndowmentDto getByCode(String code);
    void updateState(UUID id, String state);
    List<PhilanthropicEndowmentDto> listAll();
}
