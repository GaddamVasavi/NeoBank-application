package com.neobank.account;
import java.time.LocalDate; import java.util.UUID;
public interface StatementService {
    byte[] generatePdfStatement(UUID accountId, UUID userId, LocalDate startDate, LocalDate endDate);
    String generateCsvStatement(UUID accountId, UUID userId, LocalDate startDate, LocalDate endDate);
}
