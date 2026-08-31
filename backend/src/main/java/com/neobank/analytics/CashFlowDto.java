package com.neobank.analytics;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.math.BigDecimal;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class CashFlowDto {
    private String month; private BigDecimal income; private BigDecimal expense;
}
