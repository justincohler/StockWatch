package com.stockwatch.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stockwatch.api.QuoteApiService;
import com.stockwatch.domain.Quote;
import com.stockwatch.service.EmailService;
import com.stockwatch.service.QuoteService;
import com.stockwatch.service.impl.EmailServiceImpl;

/**
 * 
 * @author justincohler
 *
 *         StockWatch is the runnable class that polls the API every x minutes
 *         and performs calculations that will send emails at ideal entry and
 *         exit points for various stocks in the Nasdaq 100
 */
public class StockWatch {

	private static final int RUN_FREQUENCY = 15000;
	private static final List<String> SYMBOLS = new ArrayList<String>(Arrays.asList("AAPL", "ADBE", "ADI", "ADP", "ADSK", "AKAM", "ALTR", "ALXN", "AMAT", "AMGN", "AMZN", "ATVI", "AVGO", "BBBY", "BIDU", "BIIB", "BRCM", "CA", "CELG", "CERN", "CHKP", "CHRW", "CHTR", "CMCSA", "COST", "CSCO", "CTRX", "CTSH", "CTXS", "DISCA", "DISH", "DLTR", "DTV", "EBAY", "EQIX", "ESRX", "EXPD", "EXPE", "FAST", "FB", "FFIV", "FISV", "FOSL", "FOXA", "GILD", "GMCR", "GOOG", "GOOGL", "GRMN", "HSIC", "INTC", "INTU", "ILMN", "ISRG", "KLAC", "KRFT", "LBTYA", "QVCA", "LLTC", "LMCA", "MAR", "MAT", "MDLZ", "MNST", "MSFT", "MU", "MXIM", "MYL", "NFLX", "NTAP", "NVDA", "NXPI", "ORLY", "PAYX", "PCAR", "PCLN", "QCOM", "REGN", "ROST", "SBAC", "SBUX", "SIAL", "SNDK", "SPLS", "SRCL", "STX", "SYMC", "TSCO", "TSLA", "TRIP", "TXN", "VIAB", "VIP", "VOD", "VRSK", "VRTX", "WDC", "WFM", "WYNN", "XLNX", "YHOO"));
	private static Map<String, List<Quote>> quoteMap = new HashMap<String, List<Quote>>();
	
	public static void main(String[] args) {

		// initialize services TODO CDI injection
		EmailService emailService = new EmailServiceImpl();
		QuoteService quoteService = new QuoteApiService();
		// TODO StockEngine stockEngine = new StockEngineImpl();
		
		// application run indefinitely
		while (true) {
			
			try {
				
				// collect quotes
				List<Quote> quotes = quoteService.getQuotes(SYMBOLS);
				for (Quote quote : quotes) {
					
					// add the new quote to the list map of quotes for the current ticker
					String symbol = quote.getSymbol();
					if (quoteMap.get(symbol) == null) {
						quoteMap.put(symbol, new ArrayList<Quote>(Arrays.asList(quote)));
					} else {
						List<Quote> symbolQuotes = quoteMap.get(symbol);
						symbolQuotes.add(0, quote);
						quoteMap.put(symbol, symbolQuotes);
					}
					
					// TODO perform calculations on the quote given the list
					
				}
				
				Thread.sleep(RUN_FREQUENCY);
				
			} catch (InterruptedException e) {
				// send exception as email
				emailService.sendEmail("StockWatch Runtime Failed at " + new Date().toString(), "Failed with exception: " + e.getMessage());
			}
		}
	}

}
