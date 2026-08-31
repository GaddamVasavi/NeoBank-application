package com.neobank.openbanking;
import java.util.List; import java.util.UUID;
public interface PaymentInitiationRequestLogService {
    List<PaymentInitiationRequestLogDto> getByUser(UUID userId);
    PaymentInitiationRequestLogDto create(PaymentInitiationRequestLogDto dto);
    PaymentInitiationRequestLogDto getByCode(String code);
    void updateState(UUID id, String state);
    List<PaymentInitiationRequestLogDto> listAll();
}
