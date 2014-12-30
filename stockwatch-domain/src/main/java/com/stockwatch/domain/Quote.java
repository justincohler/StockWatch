package com.stockwatch.domain;

import java.io.Serializable;

/**
 * 
 * @author justincohler
 *
 *         Quote is a domain object mirroring the up-to-date community Yahoo
 *         Finance API
 */
public class Quote implements Serializable {
	private static final long serialVersionUID = -3321399612270717836L;

	private String symbol;
	private String name;
	private Double ask;
	private Integer averageDailyVolume;
	private Double bid;
	private Double askRealtime;
	private Double bidRealtime;
	private Double bookValue;
	private Double change;
	private String currency;
	private Double dividendShare;
	private Double earningsShare;
	private Double open;
	private Double previousClose;
	private Double priceSales;
	private Double priceBook;
	private Double daysLow;
	private Double daysHigh;
	private Double yearLow;
	private Double yearHigh;
	private Double fiftydayMovingAverage;
	private Double twoHundreddayMovingAverage;
	private Double shortRatio;
	private Integer volume;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAsk() {
		return ask;
	}

	public void setAsk(Double ask) {
		this.ask = ask;
	}

	public Integer getAverageDailyVolume() {
		return averageDailyVolume;
	}

	public void setAverageDailyVolume(Integer averageDailyVolume) {
		this.averageDailyVolume = averageDailyVolume;
	}

	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	public Double getAskRealtime() {
		return askRealtime;
	}

	public void setAskRealtime(Double askRealtime) {
		this.askRealtime = askRealtime;
	}

	public Double getBidRealtime() {
		return bidRealtime;
	}

	public void setBidRealtime(Double bidRealtime) {
		this.bidRealtime = bidRealtime;
	}

	public Double getBookValue() {
		return bookValue;
	}

	public void setBookValue(Double bookValue) {
		this.bookValue = bookValue;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getDividendShare() {
		return dividendShare;
	}

	public void setDividendShare(Double dividendShare) {
		this.dividendShare = dividendShare;
	}

	public Double getEarningsShare() {
		return earningsShare;
	}

	public void setEarningsShare(Double earningsShare) {
		this.earningsShare = earningsShare;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(Double previousClose) {
		this.previousClose = previousClose;
	}

	public Double getPriceSales() {
		return priceSales;
	}

	public void setPriceSales(Double priceSales) {
		this.priceSales = priceSales;
	}

	public Double getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(Double priceBook) {
		this.priceBook = priceBook;
	}

	public Double getDaysLow() {
		return daysLow;
	}

	public void setDaysLow(Double daysLow) {
		this.daysLow = daysLow;
	}

	public Double getDaysHigh() {
		return daysHigh;
	}

	public void setDaysHigh(Double daysHigh) {
		this.daysHigh = daysHigh;
	}

	public Double getYearLow() {
		return yearLow;
	}

	public void setYearLow(Double yearLow) {
		this.yearLow = yearLow;
	}

	public Double getYearHigh() {
		return yearHigh;
	}

	public void setYearHigh(Double yearHigh) {
		this.yearHigh = yearHigh;
	}

	public Double getFiftydayMovingAverage() {
		return fiftydayMovingAverage;
	}

	public void setFiftydayMovingAverage(Double fiftydayMovingAverage) {
		this.fiftydayMovingAverage = fiftydayMovingAverage;
	}

	public Double getTwoHundreddayMovingAverage() {
		return twoHundreddayMovingAverage;
	}

	public void setTwoHundreddayMovingAverage(Double twoHundreddayMovingAverage) {
		this.twoHundreddayMovingAverage = twoHundreddayMovingAverage;
	}

	public Double getShortRatio() {
		return shortRatio;
	}

	public void setShortRatio(Double shortRatio) {
		this.shortRatio = shortRatio;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
