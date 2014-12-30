package com.stockwatch.service;

import java.util.List;

import com.stockwatch.domain.Quote;

/**
 * 
 * @author justincohler
 *
 *         QuoteService is a generic interface used for retrieving information
 *         from both our Yahoo API and in the future a NoSQL db of some sort
 */
public interface QuoteService {

	/**
	 * 
	 * @param symbol
	 * @return Quote
	 * 
	 *         Method returns a Quote object for a given ticker symbol
	 * 
	 */
	public Quote getQuote(String symbol);

	/**
	 * 
	 * @param symbols
	 * @return
	 * 
	 *         Method returns a list of Quote objects for a given list of ticker
	 *         symbols
	 */
	public List<Quote> getQuotes(List<String> symbols);
}
