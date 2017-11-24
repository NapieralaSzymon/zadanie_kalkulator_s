package pl.wercia.calculator.service.country;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class PolandServiceTest {

	@Autowired
	private PolandService polandService;

	@Test
	public void testCalculateGain() {
		Assert.assertEquals(new BigDecimal(7128), polandService.calculateGain(new BigDecimal(10000)));
	}

}
