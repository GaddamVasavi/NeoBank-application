package com.neobank.transaction;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service;
import java.math.BigDecimal; import java.math.RoundingMode;
@Service @RequiredArgsConstructor
public class FxServiceImpl implements FxService {
    private final ExchangeRateRepository rateRepository;
    @Override
    public BigDecimal getRate(String fromCurrency, String toCurrency) {
        if (fromCurrency.equalsIgnoreCase(toCurrency)) return BigDecimal.ONE;
        return rateRepository.findTopBySourceCurrencyAndTargetCurrencyOrderByEffectiveAtDesc(fromCurrency.toUpperCase(), toCurrency.toUpperCase())
                .map(ExchangeRate::getRate)
                .orElse(BigDecimal.ONE);
    }
    @Override
    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount) {
        BigDecimal rate = getRate(fromCurrency, toCurrency);
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
