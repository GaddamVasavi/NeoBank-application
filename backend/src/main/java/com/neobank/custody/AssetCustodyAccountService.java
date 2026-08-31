package com.neobank.custody;
import java.util.List; import java.util.UUID;
public interface AssetCustodyAccountService {
    List<AssetCustodyAccountDto> getByUser(UUID userId);
    AssetCustodyAccountDto create(AssetCustodyAccountDto dto);
    AssetCustodyAccountDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<AssetCustodyAccountDto> listAll();
}
