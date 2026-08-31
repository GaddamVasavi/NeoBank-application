package com.finverse.payments;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for MerchantVirtualTerminal
 */
public interface MerchantVirtualTerminalService {

    List<MerchantVirtualTerminalDto> getByTenant(UUID tenantId);

    List<MerchantVirtualTerminalDto> getByUser(UUID userId);

    MerchantVirtualTerminalDto create(MerchantVirtualTerminalDto dto);

    MerchantVirtualTerminalDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<MerchantVirtualTerminalDto> listAll();
}
