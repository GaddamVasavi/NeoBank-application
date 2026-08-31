package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface VirtualIbanPoolService {
    List<VirtualIbanPoolDto> getByUser(UUID userId);
    VirtualIbanPoolDto create(VirtualIbanPoolDto dto);
    VirtualIbanPoolDto getByCode(String code);
    void updateState(UUID id, String state);
    List<VirtualIbanPoolDto> listAll();
}
