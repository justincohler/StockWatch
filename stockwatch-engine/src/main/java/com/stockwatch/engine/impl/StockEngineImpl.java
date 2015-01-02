package com.stockwatch.engine.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stockwatch.domain.Quote;
import com.stockwatch.engine.StockEngine;
import com.stockwatch.service.impl.EmailServiceImpl;

/**
 * 
 * @author justincohler
 *
 *         StockeEngine performs all calculations used in the StockWatch-runtime
 *         module for trading strategies
 */
public class StockEngineImpl implements StockEngine, Serializable {
	private static final long serialVersionUID = -888281558567383245L;

	final static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	public Double getMiddleBand(List<Quote> quotes) {
		// TODO
		return null;
	}

	public Double getUpperBand(List<Quote> quotes) {
		// TODO
		return null;
	}

	public Double getLowerBand(List<Quote> quotes) {
		// TODO
		return null;
	}

	public Double getCentralPivot(Quote quote) {
		return (quote.getDaysHigh() + quote.getDaysLow() + quote.getPreviousClose()) / 3;
	}

	public Double getFirstResistance(Quote quote) {
		return (2 * getCentralPivot(quote)) - quote.getDaysLow();
	}

	public Double getFirstSupport(Quote quote) {
		return (2 * getCentralPivot(quote)) - quote.getDaysHigh();
	}

	public Double getSecondResistance(Quote quote) {
		return getCentralPivot(quote) + (getFirstResistance(quote) - getFirstSupport(quote));
	}

	public Double getSecondSupport(Quote quote) {
		return getCentralPivot(quote) - (getFirstResistance(quote) - getFirstSupport(quote));
	}

}
