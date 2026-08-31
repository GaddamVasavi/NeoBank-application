package com.neobank.merchant;
import java.util.List; import java.util.UUID;
public interface MerchantPaymentTerminalService {
    List<MerchantPaymentTerminalDto> getByUser(UUID userId);
    MerchantPaymentTerminalDto create(MerchantPaymentTerminalDto dto);
    MerchantPaymentTerminalDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<MerchantPaymentTerminalDto> listAll();
}
