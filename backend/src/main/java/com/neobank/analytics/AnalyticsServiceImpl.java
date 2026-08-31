package com.neobank.analytics;
import org.springframework.stereotype.Service;
import java.math.BigDecimal; import java.util.Arrays; import java.util.List; import java.util.UUID;
@Service public class AnalyticsServiceImpl implements AnalyticsService {
    @Override public List<CashFlowDto> getUserCashFlow(UUID userId) {
        return Arrays.asList(
                new CashFlowDto("Jan", new BigDecimal("5200.00"), new BigDecimal("3100.00")),
                new CashFlowDto("Feb", new BigDecimal("5400.00"), new BigDecimal("2950.00")),
                new CashFlowDto("Mar", new BigDecimal("5300.00"), new BigDecimal("3400.00")),
                new CashFlowDto("Apr", new BigDecimal("5800.00"), new BigDecimal("3200.00")),
                new CashFlowDto("May", new BigDecimal("6100.00"), new BigDecimal("3650.00")),
                new CashFlowDto("Jun", new BigDecimal("6400.00"), new BigDecimal("3800.00"))
        );
    }
}
