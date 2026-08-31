package com.neobank.corporate;
import java.util.List; import java.util.UUID;
public interface MerchantSettlementBatchFileService {
    List<MerchantSettlementBatchFileDto> getByUser(UUID userId);
    MerchantSettlementBatchFileDto create(MerchantSettlementBatchFileDto dto);
    MerchantSettlementBatchFileDto getByCode(String code);
    void updateState(UUID id, String state);
    List<MerchantSettlementBatchFileDto> listAll();
}
