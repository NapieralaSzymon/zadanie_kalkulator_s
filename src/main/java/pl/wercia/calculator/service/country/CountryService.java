package pl.wercia.calculator.service.country;

import java.math.BigDecimal;
import java.util.Objects;

import pl.wercia.calculator.model.Country;

public abstract class CountryService {

	private static final int WORK_DAYS_IN_MONTH = 22;

	public abstract Country getCountryDetails();

	public boolean hasCountrySymbol(String countrySymbol) {
		return Objects.equals(countrySymbol, getCountryDetails().getCountrySymbol());
	}

	public abstract BigDecimal getIncomeTax();

	public abstract BigDecimal getFixedCostsSum();

	public BigDecimal calculateGainByDailyIncome(BigDecimal dailyIncome) {
		return calculateGain(dailyIncome.multiply(new BigDecimal(WORK_DAYS_IN_MONTH)));
	}

	public BigDecimal calculateGain(BigDecimal income) {
		BigDecimal gainWithTax = income.subtract(getFixedCostsSum());
		BigDecimal gainWithoutTaxPercentage = new BigDecimal(100)
				.subtract(getIncomeTax());
		BigDecimal gain = gainWithTax
				.multiply(gainWithoutTaxPercentage)
				.divide(new BigDecimal(100));
		return gain;
	}

}
