package pl.wercia.calculator.service.currency;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class FixedCurrencyServiceTest {

	@Autowired
	@Qualifier(value = "fixedCurrencyService")
	private CurrencyService currencyService;

	@Test
	public void testCalculateAmountFromPLN() {
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(100), "PLN", "THB").compareTo(new BigDecimal(1000)) == 0);
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(4000), "PLN", "EUR").compareTo(new BigDecimal(1000)) == 0);
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(3000), "PLN", "USD").compareTo(new BigDecimal(1000)) == 0);
	}

	@Test
	public void testCalculateAmountToPLN() {
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(1000), "THB", "PLN").compareTo(new BigDecimal(100)) == 0);
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(1000), "EUR", "PLN").compareTo(new BigDecimal(4000)) == 0);
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(1000), "USD", "PLN").compareTo(new BigDecimal(3000)) == 0);
	}

	@Test
	public void testCalculateAmountEurAndUsd() {
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(3000), "EUR", "USD").compareTo(new BigDecimal(4000)) == 0);
		Assert.assertEquals(true, currencyService.calculateAmount(
				new BigDecimal(4000), "USD", "EUR").compareTo(new BigDecimal(3000)) == 0);
	}

}
