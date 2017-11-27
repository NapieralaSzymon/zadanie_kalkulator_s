package pl.wercia.calculator.service.currency;

import java.math.BigDecimal;

public class Currency {

	public Currency(String currencySymbol, BigDecimal exchangeRate) {
		super();
		this.currencySymbol = currencySymbol;
		this.exchangeRate = exchangeRate;
	}

	private String currencySymbol;
	private BigDecimal exchangeRate;

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

}
