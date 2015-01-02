package com.stockwatch.engine;

import java.util.List;

import com.stockwatch.domain.Quote;

/**
 * 
 * @author justincohler
 *
 *         StockeEngine performs all calculations used in the StockWatch-runtime
 *         module for trading strategies
 */
public interface StockEngine {

	/**
	 * 
	 * @param quotes
	 * @return
	 * 
	 *         Method returns the middle b-band for a period of quotes passed in
	 */
	public Double getMiddleBand(List<Quote> quotes);

	/**
	 * 
	 * @param quotes
	 * @return
	 * 
	 *         Method returns the upper b-band for a period of quotes passed in
	 */
	public Double getUpperBand(List<Quote> quotes);

	/**
	 * 
	 * @param quotes
	 * @return
	 * 
	 *         Method returns the lower b-band for a period of quotes passed in
	 */
	public Double getLowerBand(List<Quote> quotes);

	/**
	 * 
	 * @param quote
	 * @return
	 * 
	 *         Method returns the central pivot for an instant quote: P = (high
	 *         + low + close)/3
	 */
	public Double getCentralPivot(Quote quote);

	/**
	 * 
	 * @param quote
	 * @return
	 * 
	 *         Method returns the first resistance for an instant quote
	 */
	public Double getFirstResistance(Quote quote);

	/**
	 * 
	 * @param quote
	 * @return
	 * 
	 *         Method returns the first support for an instant quote
	 */
	public Double getFirstSupport(Quote quote);

	/**
	 * 
	 * @param quote
	 * @return
	 * 
	 *         Method returns the second resistance for an instant quote
	 */
	public Double getSecondResistance(Quote quote);

	/**
	 * 
	 * @param quote
	 * @return
	 * 
	 *         Method returns the second support for an instant quote
	 */
	public Double getSecondSupport(Quote quote);

}
