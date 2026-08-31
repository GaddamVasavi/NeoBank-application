package com.neobank.fx;
import java.util.List; import java.util.UUID;
public interface AutomatedFxOrderBookService {
    List<AutomatedFxOrderBookDto> getByUser(UUID userId);
    AutomatedFxOrderBookDto create(AutomatedFxOrderBookDto dto);
    AutomatedFxOrderBookDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AutomatedFxOrderBookDto> listAll();
}
