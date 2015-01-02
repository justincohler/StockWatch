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
public class StockEngine {

	private static final int MAX_PERIOD = 30;

	/**
	 * 
	 * @param quotes
	 * @return
	 * 
	 *  Method returns the middle b-band for a period of quotes passed in
	 */
	private Double getMiddleBand(List<Quote> quotes) {
		//TODO
		return null;
	}
	
	/**
	 * 
	 * @param quotes
	 * @return
	 * 
	 *  Method returns the upper b-band for a period of quotes passed in
	 */
	private Double getUpperBand(List<Quote> quotes) {
		//TODO
		return null;
	}

	/**
	 * 
	 * @param quotes
	 * @return
	 * 
	 *  Method returns the lower b-band for a period of quotes passed in
	 */
	private Double getLowerBand(List<Quote> quotes) {
		//TODO
		return null;
	}

}
