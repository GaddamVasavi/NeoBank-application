package com.neobank.transfer;
import java.time.LocalDate; import java.util.List; import java.util.UUID;
public interface ScheduledTransferService {
    void processDueTransfers(LocalDate executionDate);
    List<ScheduledTransfer> getAccountScheduledTransfers(UUID accountId);
}
