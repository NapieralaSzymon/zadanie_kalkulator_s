package pl.wercia.calculator.service.currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FixedCurrencyService extends CurrencyService {

	@Override
	public String getBaseCurrencyCode() {
		return "PLN";
	}

	@Override
	public Map<String, BigDecimal> getExchangeRates() {
		HashMap<String, BigDecimal> exchangeRates = new HashMap<>();
		exchangeRates.put("THB", new BigDecimal("0.1"));
		exchangeRates.put("USD", new BigDecimal(3));
		exchangeRates.put("EUR", new BigDecimal(4));
		return exchangeRates;
	}

}
