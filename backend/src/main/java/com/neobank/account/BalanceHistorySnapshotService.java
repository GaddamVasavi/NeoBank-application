package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface BalanceHistorySnapshotService {
    List<BalanceHistorySnapshotDto> getByAccount(UUID accountId);
    BalanceHistorySnapshotDto create(BalanceHistorySnapshotDto dto);
    BalanceHistorySnapshotDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
