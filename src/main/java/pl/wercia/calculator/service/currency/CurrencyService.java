package pl.wercia.calculator.service.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Objects;

public abstract class CurrencyService {

	public abstract String getBaseCurrencyCode();

	public abstract Map<String, BigDecimal> getExchangeRates();

	public BigDecimal calculateAmount(BigDecimal amount,
			String sourceCurrencyCode, String targetCurrencyCode) {
		Map<String, BigDecimal> exchangeRates = getExchangeRates();
		BigDecimal baseAmount = Objects.equals(getBaseCurrencyCode(), sourceCurrencyCode)
				? amount : amount.multiply(exchangeRates.get(sourceCurrencyCode));
		return Objects.equals(getBaseCurrencyCode(), targetCurrencyCode)
				? baseAmount : baseAmount.divide(
						exchangeRates.get(targetCurrencyCode), 2, RoundingMode.HALF_UP);
	}

}
