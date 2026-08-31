package com.neobank.securities;
import java.util.List; import java.util.UUID;
public interface BrokerageAccountMandateService {
    List<BrokerageAccountMandateDto> getByUser(UUID userId);
    BrokerageAccountMandateDto create(BrokerageAccountMandateDto dto);
    BrokerageAccountMandateDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<BrokerageAccountMandateDto> listAll();
}
