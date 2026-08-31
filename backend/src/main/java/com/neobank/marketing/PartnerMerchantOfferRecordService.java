package com.neobank.marketing;
import java.util.List; import java.util.UUID;
public interface PartnerMerchantOfferRecordService {
    List<PartnerMerchantOfferRecordDto> getByUser(UUID userId);
    PartnerMerchantOfferRecordDto create(PartnerMerchantOfferRecordDto dto);
    PartnerMerchantOfferRecordDto getByCode(String code);
    void updateState(UUID id, String state);
    List<PartnerMerchantOfferRecordDto> listAll();
}
