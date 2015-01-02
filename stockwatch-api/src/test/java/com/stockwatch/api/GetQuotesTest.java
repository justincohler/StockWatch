package com.stockwatch.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Test
	public void testGetNasdaq100Quotes() {
		QuoteApiService service = new QuoteApiService();
		List<String> symbols = new ArrayList<String>(Arrays.asList("AAPL", "ADBE", "ADI", "ADP", "ADSK", "AKAM", "ALTR", "ALXN", "AMAT", "AMGN", "AMZN", "ATVI", "AVGO", "BBBY", "BIDU", "BIIB", "BRCM", "CA", "CELG", "CERN", "CHKP", "CHRW", "CHTR", "CMCSA", "COST", "CSCO", "CTRX", "CTSH", "CTXS", "DISCA", "DISH", "DLTR", "DTV", "EBAY", "EQIX", "ESRX", "EXPD", "EXPE", "FAST", "FB", "FFIV", "FISV", "FOSL", "FOXA", "GILD", "GMCR", "GOOG", "GOOGL", "GRMN", "HSIC", "INTC", "INTU", "ILMN", "ISRG", "KLAC", "KRFT", "LBTYA", "QVCA", "LLTC", "LMCA", "MAR", "MAT", "MDLZ", "MNST", "MSFT", "MU", "MXIM", "MYL", "NFLX", "NTAP", "NVDA", "NXPI", "ORLY", "PAYX", "PCAR", "PCLN", "QCOM", "REGN", "ROST", "SBAC", "SBUX", "SIAL", "SNDK", "SPLS", "SRCL", "STX", "SYMC", "TSCO", "TSLA", "TRIP", "TXN", "VIAB", "VIP", "VOD", "VRSK", "VRTX", "WDC", "WFM", "WYNN", "XLNX", "YHOO"));
		
		assertNotNull(symbols);
		logger.info("Symbols: " + symbols.toString());
		
		List<Quote> quotes = service.getQuotes(symbols);
		
		assertNotNull(quotes);
		assertEquals(101, quotes.size());
		
		for(Quote quote : quotes) {
			logger.info("********************************");
			logger.info("Symbol: " + quote.getSymbol());
			logger.info("Previous Close: " + quote.getPreviousClose().toString());
		}
		logger.info("...passed.");

	}

}
