package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class GreatBritainService extends CountryService {

	@Override
	public String getCountrySymbol() {
		return "UK";
	}

	@Override
	public String getCurrencySymbol() {
		return "GBP";
	}

	@Override
	public BigDecimal getIncomeTax() {
		return new BigDecimal(25);
	}

	@Override
	public BigDecimal getFixedCostsSum() {
		return new BigDecimal(600);
	}

}
