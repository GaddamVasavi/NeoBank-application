package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface ActuarialLossReserveModelService {
    List<ActuarialLossReserveModelDto> getByUser(UUID userId);
    ActuarialLossReserveModelDto create(ActuarialLossReserveModelDto dto);
    ActuarialLossReserveModelDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ActuarialLossReserveModelDto> listAll();
}
