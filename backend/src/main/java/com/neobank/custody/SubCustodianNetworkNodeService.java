package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface SubCustodianNetworkNodeService {
    List<SubCustodianNetworkNodeDto> getByUser(UUID userId);
    SubCustodianNetworkNodeDto create(SubCustodianNetworkNodeDto dto);
    SubCustodianNetworkNodeDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SubCustodianNetworkNodeDto> listAll();
}
