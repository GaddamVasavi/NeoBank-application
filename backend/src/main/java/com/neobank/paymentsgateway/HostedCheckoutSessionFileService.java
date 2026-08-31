package com.neobank.paymentsgateway;
import java.util.List; import java.util.UUID;
public interface HostedCheckoutSessionFileService {
    List<HostedCheckoutSessionFileDto> getByUser(UUID userId);
    HostedCheckoutSessionFileDto create(HostedCheckoutSessionFileDto dto);
    HostedCheckoutSessionFileDto getByIdentifier(String id);
    void updateState(UUID id, String state);
    List<HostedCheckoutSessionFileDto> listAll();
}
