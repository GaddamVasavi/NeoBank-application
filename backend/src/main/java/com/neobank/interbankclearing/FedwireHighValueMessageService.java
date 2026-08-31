package com.neobank.interbankclearing;
import java.util.List; import java.util.UUID;
public interface FedwireHighValueMessageService {
    List<FedwireHighValueMessageDto> getByUser(UUID userId);
    FedwireHighValueMessageDto create(FedwireHighValueMessageDto dto);
    FedwireHighValueMessageDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<FedwireHighValueMessageDto> listAll();
}
