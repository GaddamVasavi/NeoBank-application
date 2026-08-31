package com.neobank.transaction;
import java.math.BigDecimal;
public interface FxService {
    BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount);
    BigDecimal getRate(String fromCurrency, String toCurrency);
}
