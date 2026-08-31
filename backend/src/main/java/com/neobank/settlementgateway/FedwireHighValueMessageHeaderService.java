package com.neobank.settlementgateway;
import java.util.List; import java.util.UUID;
public interface FedwireHighValueMessageHeaderService {
    List<FedwireHighValueMessageHeaderDto> getByUser(UUID userId);
    FedwireHighValueMessageHeaderDto create(FedwireHighValueMessageHeaderDto dto);
    FedwireHighValueMessageHeaderDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<FedwireHighValueMessageHeaderDto> listAll();
}
