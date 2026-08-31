package com.neobank.trade;
import java.util.List; import java.util.UUID;
public interface CustomsExportClearanceService {
    List<CustomsExportClearanceDto> getByUser(UUID userId);
    CustomsExportClearanceDto create(CustomsExportClearanceDto dto);
    CustomsExportClearanceDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<CustomsExportClearanceDto> listAll();
}
