package com.neobank.leasing;
import java.util.List; import java.util.UUID;
public interface LeaseAssetDepreciationLogService {
    List<LeaseAssetDepreciationLogDto> getByUser(UUID userId);
    LeaseAssetDepreciationLogDto create(LeaseAssetDepreciationLogDto dto);
    LeaseAssetDepreciationLogDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<LeaseAssetDepreciationLogDto> listAll();
}
