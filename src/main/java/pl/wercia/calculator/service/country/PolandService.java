package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class PolandService extends CountryService {

	@Override
	public String getCountrySymbol() {
		return "PL";
	}

	@Override
	public String getCurrencySymbol() {
		return "PLN";
	}

	@Override
	public BigDecimal getIncomeTax() {
		return new BigDecimal(19);
	}

	@Override
	public BigDecimal getFixedCostsSum() {
		return new BigDecimal(1200);
	}

}
