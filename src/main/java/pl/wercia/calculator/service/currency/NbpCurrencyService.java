package pl.wercia.calculator.service.currency;

import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class NbpCurrencyService extends CurrencyService {

	private static final String LAST_A_XML = "http://www.nbp.pl/kursy/xml/LastA.xml";
	private static final String XML_CURRENCY_ITEM = "pozycja";
	private static final String XML_CURRENCY_ITEM_CODE = "kod_waluty";
	private static final String XML_CURRENCY_ITEM_RATE = "kurs_sredni";

	private static final Logger logger = LoggerFactory.getLogger(NbpCurrencyService.class);

	@Override
	public String getBaseCurrencyCode() {
		return "PLN";
	}

	@Override
	public Map<String, BigDecimal> getExchangeRates() {
		Map<String, BigDecimal> exchangeRates = new HashMap<>();
		try {
			Document document = getLastATableDocument();
			Element xmlRoot = document.getDocumentElement();
			NodeList itemNodes = xmlRoot.getElementsByTagName(XML_CURRENCY_ITEM);
			for (int i = 0; i < itemNodes.getLength(); ++i) {
				Element itemElement = (Element) itemNodes.item(i);
				String currencyCode = getTextContentFromFirstTag(itemElement, XML_CURRENCY_ITEM_CODE);
				String exchangeRate = getTextContentFromFirstTag(itemElement, XML_CURRENCY_ITEM_RATE);
				exchangeRates.put(currencyCode, new BigDecimal(exchangeRate.replaceAll(",", ".")));
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return exchangeRates;
	}

	private Document getLastATableDocument() throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		return documentBuilder.parse(new URL(LAST_A_XML).openStream());
	}

	private String getTextContentFromFirstTag(Element parentElement, String tagName) {
		return parentElement.getElementsByTagName(tagName).item(0).getTextContent();
	}

}
