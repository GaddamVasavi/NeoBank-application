package com.neobank.commercial;
import java.util.List; import java.util.UUID;
public interface MerchantAcquiringAccountService {
    List<MerchantAcquiringAccountDto> getByUser(UUID userId);
    MerchantAcquiringAccountDto create(MerchantAcquiringAccountDto dto);
    MerchantAcquiringAccountDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<MerchantAcquiringAccountDto> listAll();
}
