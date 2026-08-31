package com.neobank.reconciliation;
import java.util.List; import java.util.UUID;
public interface SuspenseAccountClearanceService {
    List<SuspenseAccountClearanceDto> getByUser(UUID userId);
    SuspenseAccountClearanceDto create(SuspenseAccountClearanceDto dto);
    SuspenseAccountClearanceDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SuspenseAccountClearanceDto> listAll();
}
