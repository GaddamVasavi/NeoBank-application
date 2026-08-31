package com.neobank.transfer;
import com.neobank.account.Account; import com.neobank.account.AccountRepository;
import com.neobank.common.ResourceNotFoundException;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class CashbackRewardPoolServiceImpl implements CashbackRewardPoolService {
    private final CashbackRewardPoolRepository repository;
    private final AccountRepository accountRepository;
    @Override @Transactional(readOnly = true) public List<CashbackRewardPoolDto> getByAccount(UUID accountId) { return repository.findBySourceAccountId(accountId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public CashbackRewardPoolDto create(CashbackRewardPoolDto dto) {
        Account a = accountRepository.findById(dto.getSourceAccountId()).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        CashbackRewardPool entity = CashbackRewardPool.builder().sourceAccount(a).trackingNumber(dto.getTrackingNumber() != null ? dto.getTrackingNumber() : UUID.randomUUID().toString()).amount(dto.getAmount()).currency(dto.getCurrency() != null ? dto.getCurrency() : "USD").status("PENDING").counterpartyInfo(dto.getCounterpartyInfo()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public CashbackRewardPoolDto getByTrackingNumber(String t) { return repository.findByTrackingNumber(t).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void process(UUID id) {
        CashbackRewardPool entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setStatus("COMPLETED"); entity.setProcessedAt(Instant.now()); repository.save(entity);
    }
    private CashbackRewardPoolDto mapToDto(CashbackRewardPool e) {
        return CashbackRewardPoolDto.builder().id(e.getId()).sourceAccountId(e.getSourceAccount().getId()).trackingNumber(e.getTrackingNumber()).status(e.getStatus()).amount(e.getAmount()).currency(e.getCurrency()).counterpartyInfo(e.getCounterpartyInfo()).processedAt(e.getProcessedAt()).build();
    }
}
