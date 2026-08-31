package com.neobank.syndicatedloans;
import java.util.List; import java.util.UUID;
public interface IntercreditorSubordinationService {
    List<IntercreditorSubordinationDto> getByUser(UUID userId);
    IntercreditorSubordinationDto create(IntercreditorSubordinationDto dto);
    IntercreditorSubordinationDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<IntercreditorSubordinationDto> listAll();
}
