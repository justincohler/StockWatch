package com.stockwatch.service;

import com.stockwatch.domain.Quote;

public interface QuoteService {

	public Quote getQuote(String symbol);
}
