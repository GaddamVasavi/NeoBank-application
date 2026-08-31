package com.neobank.insurance;
import java.util.List; import java.util.UUID;
public interface ReinsuranceTreatyContractService {
    List<ReinsuranceTreatyContractDto> getByUser(UUID userId);
    ReinsuranceTreatyContractDto create(ReinsuranceTreatyContractDto dto);
    ReinsuranceTreatyContractDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ReinsuranceTreatyContractDto> listAll();
}
