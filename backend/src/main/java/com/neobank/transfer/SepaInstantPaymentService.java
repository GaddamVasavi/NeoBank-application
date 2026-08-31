package com.neobank.transfer;
import java.util.List; import java.util.UUID;
public interface SepaInstantPaymentService {
    List<SepaInstantPaymentDto> getByAccount(UUID accountId);
    SepaInstantPaymentDto create(SepaInstantPaymentDto dto);
    SepaInstantPaymentDto getByTrackingNumber(String trackingNumber);
    void process(UUID id);
}
