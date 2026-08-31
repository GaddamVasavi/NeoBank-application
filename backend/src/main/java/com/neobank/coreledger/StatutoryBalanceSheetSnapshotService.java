package com.neobank.coreledger;
import java.util.List; import java.util.UUID;
public interface StatutoryBalanceSheetSnapshotService {
    List<StatutoryBalanceSheetSnapshotDto> getByUser(UUID userId);
    StatutoryBalanceSheetSnapshotDto create(StatutoryBalanceSheetSnapshotDto dto);
    StatutoryBalanceSheetSnapshotDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<StatutoryBalanceSheetSnapshotDto> listAll();
}
