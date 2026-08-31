package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface BillDisputeInvestigationService {
    List<BillDisputeInvestigationDto> getByUser(UUID userId);
    BillDisputeInvestigationDto create(BillDisputeInvestigationDto dto);
    BillDisputeInvestigationDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BillDisputeInvestigationDto> listAll();
}
