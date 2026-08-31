package com.neobank.settlement;
import java.util.List; import java.util.UUID;
public interface FedwireFundsTransferService {
    List<FedwireFundsTransferDto> getByUser(UUID userId);
    FedwireFundsTransferDto create(FedwireFundsTransferDto dto);
    FedwireFundsTransferDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<FedwireFundsTransferDto> listAll();
}
