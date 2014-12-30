package com.stockwatch.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stockwatch.api.util.JsonHelper;
import com.stockwatch.domain.Quote;
import com.stockwatch.service.QuoteService;

/**
 * 
 * @author justincohler
 *
 *         QuoteApiService interacts with the yahoo api via yql queries to
 *         collect json quote information and unmarshals the json into Quote
 *         objects
 */
public class QuoteApiService implements QuoteService, Serializable {
	private static final long serialVersionUID = -6590943621918128824L;

	final static Logger logger = LoggerFactory.getLogger(QuoteApiService.class);
	
	private static final String BASE_URL = "https://query.yahooapis.com/v1/public/yql";
	private static final String UTF8 = "UTF-8";
	private static final String QUOTE = "quote";

	/**
	 * Method returns a Quote object for the given symbol parameter
	 */
	public Quote getQuote(String symbol) {
		String url = generateQueryString(new ArrayList<String>(Arrays.asList(symbol)));
		if (url == null) {
			logger.error("Failed to generate url for quote query with the symbol: " + symbol);
			return null;
		}
		logger.info("Calling url: " + url);
		String result = executeHttpGet(url);
		if (result == null) {
			logger.error("Failed to execute http get with query for symbol: " + symbol + " at url: " + url);
			return null;
		}
		logger.info("Returned message: " + result);
		return (Quote) JsonHelper.fromJson(result, Quote.class, QUOTE);

	}
	
	public List<Quote> getQuotes(List<String> symbols) {
		String url = generateQueryString(symbols);
		if (url == null) {
			logger.error("Failed to generate url for quote query with the symbols: " + symbols.toString());
			return null;
		}
		logger.info("Calling url: " + url);
		String result = executeHttpGet(url);
		if (result == null) {
			logger.error("Failed to execute http get with query for symbols: " + symbols.toString() + " at url: " + url);
			return null;
		}
		logger.info("Returned message: " + result);
		return JsonHelper.quotesFromJson(result, QUOTE);
	}

	public String executeHttpGet(String url) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response;
		try {
			response = client.execute(request);

			logger.info("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			return result.toString();
		} catch (ClientProtocolException e) {
			System.out.println("ClientProtocolException found with message: " + e.getMessage());
			return null;
		} catch (IOException e) {
			System.out.println("IOException found with message: " + e.getMessage());
			return null;
		}
	}

	public String generateQueryString(List<String> symbols) {
		StringBuffer sb = new StringBuffer(BASE_URL);
		sb.append("?q=");
		try {

			sb.append(URLEncoder.encode("select * from yahoo.finance.quotes where symbol in (", UTF8));
			Iterator<String> it = symbols.iterator();
			while(it.hasNext()) {
				sb.append(URLEncoder.encode("\"", UTF8));
				sb.append(it.next());
				sb.append(URLEncoder.encode("\"", UTF8));
				if (it.hasNext()) {
					sb.append(",");
				}
			}
			
			sb.append(URLEncoder.encode(")", UTF8));
			sb.append("&format=json");
			sb.append("&env=store%3a%2F%2Fdatatables.org%2Falltableswithkeys&callback=");
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException found with message: " + e.getMessage());
			return null;
		}
	}

}
