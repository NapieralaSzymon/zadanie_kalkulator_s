package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class GermanyService extends CountryService {

	@Override
	public String getCountrySymbol() {
		return "DE";
	}

	@Override
	public String getCurrencySymbol() {
		return "EUR";
	}

	@Override
	public BigDecimal getIncomeTax() {
		return new BigDecimal(20);
	}

	@Override
	public BigDecimal getFixedCostsSum() {
		return new BigDecimal(800);
	}

}
