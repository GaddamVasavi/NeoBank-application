package com.neobank.corepayments;
import java.util.List; import java.util.UUID;
public interface AutomatedClearingHouseNachaService {
    List<AutomatedClearingHouseNachaDto> getByUser(UUID userId);
    AutomatedClearingHouseNachaDto create(AutomatedClearingHouseNachaDto dto);
    AutomatedClearingHouseNachaDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<AutomatedClearingHouseNachaDto> listAll();
}
