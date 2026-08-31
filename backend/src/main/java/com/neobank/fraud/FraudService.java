package com.neobank.fraud;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
public interface FraudService {
    int evaluateTransactionRisk(UUID userId, BigDecimal amount);
    List<FraudCase> getOpenCases();
    void resolveCase(UUID caseId, UUID resolverId, String resolution, String notes);
    List<FraudRule> getRules();
}
