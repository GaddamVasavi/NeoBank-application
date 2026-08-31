package com.neobank.factoring;
import java.util.List; import java.util.UUID;
public interface DelinquentDebtorRecoveryService {
    List<DelinquentDebtorRecoveryDto> getByUser(UUID userId);
    DelinquentDebtorRecoveryDto create(DelinquentDebtorRecoveryDto dto);
    DelinquentDebtorRecoveryDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<DelinquentDebtorRecoveryDto> listAll();
}
