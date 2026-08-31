package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface Target2PaymentInstructionService {
    List<Target2PaymentInstructionDto> getByUser(UUID userId);
    Target2PaymentInstructionDto create(Target2PaymentInstructionDto dto);
    Target2PaymentInstructionDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<Target2PaymentInstructionDto> listAll();
}
