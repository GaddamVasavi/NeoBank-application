package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface ApiUsageQuotaAllocationService {
    List<ApiUsageQuotaAllocationDto> getByUser(UUID userId);
    ApiUsageQuotaAllocationDto create(ApiUsageQuotaAllocationDto dto);
    ApiUsageQuotaAllocationDto getByCode(String code);
    void updateState(UUID id, String state);
    List<ApiUsageQuotaAllocationDto> listAll();
}
