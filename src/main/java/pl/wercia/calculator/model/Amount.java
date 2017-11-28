package pl.wercia.calculator.model;

import java.math.BigDecimal;

public class Amount {

	public Amount() {
		super();
	}

	public Amount(String currencySymbol, BigDecimal amount) {
		super();
		this.currencySymbol = currencySymbol;
		this.amount = amount;
	}

	private String currencySymbol;
	private BigDecimal amount;

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
