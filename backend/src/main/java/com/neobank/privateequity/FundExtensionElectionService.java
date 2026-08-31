package com.neobank.privateequity;
import java.util.List; import java.util.UUID;
public interface FundExtensionElectionService {
    List<FundExtensionElectionDto> getByUser(UUID userId);
    FundExtensionElectionDto create(FundExtensionElectionDto dto);
    FundExtensionElectionDto getByRef(String ref);
    void updateState(UUID id, String state);
    List<FundExtensionElectionDto> listAll();
}
