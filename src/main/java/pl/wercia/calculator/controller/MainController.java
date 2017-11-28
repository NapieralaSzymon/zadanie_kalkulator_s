package pl.wercia.calculator.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.wercia.calculator.model.Amount;
import pl.wercia.calculator.model.Country;
import pl.wercia.calculator.service.country.CountryService;
import pl.wercia.calculator.service.currency.CurrencyService;

@RestController
@RequestMapping(value = "/api")
public class MainController {

	@Autowired
	private List<CountryService> countryServices;

	@Autowired
	@Qualifier(value = "nbpCurrencyService")
	private CurrencyService currencyService;

	@RequestMapping(value = "/countries")
	public List<Country> getAvailableCountries() {
		return countryServices.stream()
				.map(countryService -> countryService.getCountryDetails())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/gain")
	public Amount getGain(
			@RequestParam(value = "countryCode", defaultValue = "") String countryCode,
			@RequestParam(value = "dailyIncome", defaultValue = "0") BigDecimal dailyIncome,
			@RequestParam(value = "targetCurrency", defaultValue = "PLN") String targetCurrency) {
		Optional<CountryService> countryService = countryServices.stream()
				.filter(service -> service.hasCountrySymbol(countryCode))
				.findFirst();
		Amount amount = new Amount();
		if (countryService.isPresent()) {
			amount.setCurrencySymbol(countryService.get().getCountryDetails().getCurrencySymbol());
			amount.setAmount(countryService.get().calculateGainByDailyIncome(dailyIncome));
		}
		if ((amount.getCurrencySymbol() != null) && !targetCurrency.isEmpty()) {
			amount.setAmount(currencyService.calculateAmount(amount.getAmount(),
					amount.getCurrencySymbol(), targetCurrency));
			amount.setCurrencySymbol(targetCurrency);
		}
		return amount;
	}

}
