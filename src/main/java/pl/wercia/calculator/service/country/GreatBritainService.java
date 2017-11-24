package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pl.wercia.calculator.model.Country;

@Service
public class GreatBritainService extends CountryService {

	@Override
	public Country getCountryDetails() {
		return new Country("UK", "GBP");
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
