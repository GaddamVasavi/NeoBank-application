package com.neobank.analytics;
import java.util.List; import java.util.UUID;
public interface AnalyticsService {
    List<CashFlowDto> getUserCashFlow(UUID userId);
}
