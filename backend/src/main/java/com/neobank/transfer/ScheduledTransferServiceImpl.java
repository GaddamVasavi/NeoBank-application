package com.neobank.transfer;
import lombok.RequiredArgsConstructor; import lombok.extern.slf4j.Slf4j; import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.time.LocalDate; import java.util.List; import java.util.UUID;
@Slf4j @Service @RequiredArgsConstructor
public class ScheduledTransferServiceImpl implements ScheduledTransferService {
    private final ScheduledTransferRepository scheduledTransferRepository;
    private final TransferService transferService;
    @Scheduled(cron = "0 0 2 * * ?")
    public void runDailyScheduledTransfers() {
        processDueTransfers(LocalDate.now());
    }
    @Override @Transactional
    public void processDueTransfers(LocalDate date) {
        List<ScheduledTransfer> due = scheduledTransferRepository.findByExecutionDateAndActiveTrue(date);
        for (ScheduledTransfer st : due) {
            try {
                TransferRequest req = new TransferRequest();
                req.setSourceAccountId(st.getSourceAccount().getId());
                req.setDestinationAccountNumber(st.getDestinationAccountNumber());
                req.setAmount(st.getAmount());
                req.setNote(st.getNote());
                transferService.executeTransfer(st.getSourceAccount().getUser().getId(), req);
                if ("ONE_TIME".equalsIgnoreCase(st.getFrequency())) { st.setActive(false); } else { st.setExecutionDate(st.getExecutionDate().plusMonths(1)); }
                scheduledTransferRepository.save(st);
            } catch (Exception e) {
                log.error("Failed scheduled transfer {}: {}", st.getId(), e.getMessage());
            }
        }
    }
    @Override @Transactional(readOnly = true)
    public List<ScheduledTransfer> getAccountScheduledTransfers(UUID accountId) {
        return scheduledTransferRepository.findBySourceAccountId(accountId);
    }
}
