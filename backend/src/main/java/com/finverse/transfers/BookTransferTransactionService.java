package com.finverse.transfers;

import java.util.List;
import java.util.UUID;

/**
 * Business Service Interface for BookTransferTransaction
 */
public interface BookTransferTransactionService {

    List<BookTransferTransactionDto> getByTenant(UUID tenantId);

    List<BookTransferTransactionDto> getByUser(UUID userId);

    BookTransferTransactionDto create(BookTransferTransactionDto dto);

    BookTransferTransactionDto getByReference(String ref);

    void updateStatus(UUID id, String status);

    List<BookTransferTransactionDto> listAll();
}
