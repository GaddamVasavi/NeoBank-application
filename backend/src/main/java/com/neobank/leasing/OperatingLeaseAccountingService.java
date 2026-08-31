package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface OperatingLeaseAccountingService {
    List<OperatingLeaseAccountingDto> getByUser(UUID userId);
    OperatingLeaseAccountingDto create(OperatingLeaseAccountingDto dto);
    OperatingLeaseAccountingDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<OperatingLeaseAccountingDto> listAll();
}
