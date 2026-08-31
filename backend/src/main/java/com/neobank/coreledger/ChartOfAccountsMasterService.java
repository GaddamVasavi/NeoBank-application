package com.neobank.coreledger;
import java.util.List; import java.util.UUID;
public interface ChartOfAccountsMasterService {
    List<ChartOfAccountsMasterDto> getByUser(UUID userId);
    ChartOfAccountsMasterDto create(ChartOfAccountsMasterDto dto);
    ChartOfAccountsMasterDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ChartOfAccountsMasterDto> listAll();
}
