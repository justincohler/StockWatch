package com.stockwatch.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stockwatch.domain.Quote;

public class GetQuotesTest {

	final static Logger logger = LoggerFactory.getLogger(GetQuotesTest.class);

	@Test
	public void testGetAAPLQuote() {
		QuoteApiService service = new QuoteApiService();
		Quote quote = service.getQuote("AAPL");
		assertNotNull(quote);
		assertNotNull(quote.getName());
		logger.info("Found quote: " + quote.getName());
		logger.info("...passed.");
	}

}
