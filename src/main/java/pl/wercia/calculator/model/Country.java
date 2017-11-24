package pl.wercia.calculator.model;

public class Country {

	public Country(String countrySymbol, String currencySymbol) {
		super();
		this.countrySymbol = countrySymbol;
		this.currencySymbol = currencySymbol;
	}

	private String countrySymbol;
	private String currencySymbol;

	public String getCountrySymbol() {
		return countrySymbol;
	}

	public void setCountrySymbol(String countrySymbol) {
		this.countrySymbol = countrySymbol;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

}
