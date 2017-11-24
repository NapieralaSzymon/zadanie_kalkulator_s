package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pl.wercia.calculator.model.Country;

@Service
public class GermanyService extends CountryService {

	@Override
	public Country getCountryDetails() {
		return new Country("DE", "EUR");
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
