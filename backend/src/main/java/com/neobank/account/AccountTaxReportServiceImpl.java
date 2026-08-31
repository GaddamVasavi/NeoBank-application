package com.neobank.account;
import com.neobank.common.ResourceNotFoundException;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class AccountTaxReportServiceImpl implements AccountTaxReportService {
    private final AccountTaxReportRepository repository;
    private final AccountRepository accountRepository;
    @Override @Transactional(readOnly = true) public List<AccountTaxReportDto> getByAccount(UUID accountId) { return repository.findByAccountId(accountId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public AccountTaxReportDto create(AccountTaxReportDto dto) {
        Account a = accountRepository.findById(dto.getAccountId()).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        AccountTaxReport entity = AccountTaxReport.builder().account(a).referenceCode(dto.getReferenceCode() != null ? dto.getReferenceCode() : UUID.randomUUID().toString()).amount(dto.getAmount()).status("ACTIVE").notes(dto.getNotes()).active(true).effectiveDate(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public AccountTaxReportDto getByRef(String ref) { return repository.findByReferenceCode(ref).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        AccountTaxReport entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setStatus(status); repository.save(entity);
    }
    private AccountTaxReportDto mapToDto(AccountTaxReport e) {
        return AccountTaxReportDto.builder().id(e.getId()).accountId(e.getAccount().getId()).referenceCode(e.getReferenceCode()).status(e.getStatus()).amount(e.getAmount()).notes(e.getNotes()).active(e.isActive()).effectiveDate(e.getEffectiveDate()).build();
    }
}
