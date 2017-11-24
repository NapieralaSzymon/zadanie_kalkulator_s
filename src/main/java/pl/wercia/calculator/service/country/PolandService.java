package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pl.wercia.calculator.model.Country;

@Service
public class PolandService extends CountryService {

	@Override
	public Country getCountryDetails() {
		return new Country("PL", "PLN");
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
