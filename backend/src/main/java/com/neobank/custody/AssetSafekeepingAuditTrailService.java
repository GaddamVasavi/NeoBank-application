package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface AssetSafekeepingAuditTrailService {
    List<AssetSafekeepingAuditTrailDto> getByUser(UUID userId);
    AssetSafekeepingAuditTrailDto create(AssetSafekeepingAuditTrailDto dto);
    AssetSafekeepingAuditTrailDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AssetSafekeepingAuditTrailDto> listAll();
}
