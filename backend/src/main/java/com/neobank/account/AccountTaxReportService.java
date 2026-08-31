package com.neobank.account;
import java.util.List; import java.util.UUID;
public interface AccountTaxReportService {
    List<AccountTaxReportDto> getByAccount(UUID accountId);
    AccountTaxReportDto create(AccountTaxReportDto dto);
    AccountTaxReportDto getByRef(String ref);
    void updateStatus(UUID id, String status);
}
