package pl.wercia.calculator.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.wercia.calculator.model.Country;
import pl.wercia.calculator.service.country.CountryService;

@RestController
@RequestMapping(value = "/api")
public class CountryController {

	@Autowired
	private List<CountryService> countryServices;

	@RequestMapping(value = "/countries")
	public List<Country> getAvailableCountries() {
		return countryServices.stream()
				.map(countryService -> countryService.getCountryDetails())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/gain")
	public BigDecimal getGain(
			@RequestParam(value = "countryCode", defaultValue = "") String countryCode,
			@RequestParam(value = "dailyIncome", defaultValue = "0") BigDecimal dailyIncome) {
		Optional<CountryService> countryService = countryServices.stream()
				.filter(service -> service.hasCountrySymbol(countryCode))
				.findFirst();
		return countryService.isPresent()
				? countryService.get().calculateGainByDailyIncome(dailyIncome)
				: new BigDecimal(0);
	}

}
