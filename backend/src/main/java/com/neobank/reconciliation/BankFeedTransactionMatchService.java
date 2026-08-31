package com.neobank.reconciliation;
import java.util.List; import java.util.UUID;
public interface BankFeedTransactionMatchService {
    List<BankFeedTransactionMatchDto> getByUser(UUID userId);
    BankFeedTransactionMatchDto create(BankFeedTransactionMatchDto dto);
    BankFeedTransactionMatchDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<BankFeedTransactionMatchDto> listAll();
}
