package com.neobank.bill;
import java.util.List; import java.util.UUID;
public interface BillerCategoryMappingService {
    List<BillerCategoryMappingDto> getByUser(UUID userId);
    BillerCategoryMappingDto create(BillerCategoryMappingDto dto);
    BillerCategoryMappingDto getByKey(String key);
    void updateStatus(UUID id, String status);
    List<BillerCategoryMappingDto> listAll();
}
