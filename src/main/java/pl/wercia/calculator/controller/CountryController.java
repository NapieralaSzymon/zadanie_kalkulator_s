package pl.wercia.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.wercia.calculator.service.country.CountryService;

@RestController
public class CountryController {

	@Autowired
	private List<CountryService> countryServices;

	@RequestMapping(value = "/countries")
	public List<CountryService> getCountries() {
		return countryServices;
	}

}
