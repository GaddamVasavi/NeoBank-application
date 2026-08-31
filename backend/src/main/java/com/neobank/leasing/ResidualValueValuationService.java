package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface ResidualValueValuationService {
    List<ResidualValueValuationDto> getByUser(UUID userId);
    ResidualValueValuationDto create(ResidualValueValuationDto dto);
    ResidualValueValuationDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ResidualValueValuationDto> listAll();
}
