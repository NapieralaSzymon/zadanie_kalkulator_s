package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

public abstract class CountryService {

	public abstract String getCountrySymbol();

	public abstract String getCurrencySymbol();

	public abstract BigDecimal getIncomeTax();

	public abstract BigDecimal getFixedCostsSum();

}
