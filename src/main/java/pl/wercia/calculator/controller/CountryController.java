package pl.wercia.calculator.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.wercia.calculator.service.country.CountryService;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

	@Autowired
	private List<CountryService> countryServices;

	@RequestMapping(value = "/symbols")
	public List<String> getAvailableCountrySymbols() {
		return countryServices.stream()
				.map(countryService -> countryService.getCountrySymbol())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/gain")
	public BigDecimal getGain(
			@RequestParam(value = "countryCode") String countryCode,
			@RequestParam(value = "dailyIncome") BigDecimal dailyIncome) {
		CountryService countryService = countryServices.stream()
				.filter(service -> service.getCountrySymbol().equals(countryCode))
				.findFirst().get();
		return countryService.calculateGainByDailyIncome(dailyIncome);
	}

}
