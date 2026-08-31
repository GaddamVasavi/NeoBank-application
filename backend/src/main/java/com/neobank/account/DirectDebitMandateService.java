package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface DirectDebitMandateService {
    List<DirectDebitMandateDto> getByAccount(UUID accountId);
    DirectDebitMandateDto create(DirectDebitMandateDto dto);
    DirectDebitMandateDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
