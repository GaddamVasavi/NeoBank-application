package com.neobank.investment;
import java.util.List; import java.util.UUID;
public interface DividendPaymentCreditService {
    List<DividendPaymentCreditDto> getByUser(UUID userId);
    DividendPaymentCreditDto create(DividendPaymentCreditDto dto);
    DividendPaymentCreditDto getByCode(String code);
    void updateStatus(UUID id, String status);
    List<DividendPaymentCreditDto> listAll();
}
