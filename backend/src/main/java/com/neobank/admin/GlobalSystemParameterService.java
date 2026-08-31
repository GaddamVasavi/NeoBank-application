package com.neobank.admin;
import java.util.List; import java.util.UUID;
public interface GlobalSystemParameterService {
    List<GlobalSystemParameterDto> getByUser(UUID userId);
    GlobalSystemParameterDto create(GlobalSystemParameterDto dto);
    GlobalSystemParameterDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<GlobalSystemParameterDto> listAll();
}
