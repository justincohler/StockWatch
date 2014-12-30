package com.stockwatch.api.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockwatch.domain.Quote;

/**
 * 
 * @author justincohler
 *
 *         JsonHelper is a little helper class to perform the json unmarshalling
 *         using the Jackson libraries
 */
public class JsonHelper implements Serializable {
	private static final long serialVersionUID = -73592699099532670L;

	final static Logger logger = LoggerFactory.getLogger(JsonHelper.class);

	public static List<Quote> quotesFromJson(String json, String resultProperty) {
		ObjectMapper mapper = new ObjectMapper(); 
		mapper.setPropertyNamingStrategy(new CamelCaseStrategy());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			JsonNode rootNode = mapper.readTree(json);
			Iterator<Entry<String, JsonNode>> nodeIterator = rootNode.get("query").fields();
			while (nodeIterator.hasNext()) {
				Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator.next();
				if (entry.getKey().equalsIgnoreCase("results")) {
					logger.debug(entry.getValue().toString());
					if (entry.getValue().get(resultProperty) != null) {
						List<Quote> quotes = mapper.readValue(entry.getValue().get(resultProperty).toString(), new TypeReference<ArrayList<Quote>>() { });
						return quotes;
					} else {
						logger.error("Property: " + resultProperty + "not found in results from api call.");
					}
				}
			}

			return null;

		} catch (JsonParseException e) {
			logger.error("Failed to read json with message: " + e.getMessage());
			return null;
		} catch (JsonMappingException e) {
			logger.error("Failed to read json with message: " + e.getMessage());
			return null;
		} catch (IOException e) {
			logger.error("Failed to read json with message: " + e.getMessage());
			return null;
		}
		
	}
	public static Object fromJson(String json, @SuppressWarnings("rawtypes") Class clazz, String resultProperty) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(new CamelCaseStrategy());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			JsonNode rootNode = mapper.readTree(json);
			Iterator<Entry<String, JsonNode>> nodeIterator = rootNode.get("query").fields();
			while (nodeIterator.hasNext()) {
				Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator.next();
				if (entry.getKey().equalsIgnoreCase("results")) {
					logger.debug(entry.getValue().toString());
					if (entry.getValue().get(resultProperty) != null) {
						@SuppressWarnings("unchecked")
						Object obj = mapper.readValue(entry.getValue().get(resultProperty).toString(), clazz);
						return obj;
					} else {
						logger.error("Property: " + resultProperty + "not found in results from api call.");
					}
				}
			}

			return null;

		} catch (JsonParseException e) {
			logger.error("Failed to read json with message: " + e.getMessage());
			return null;
		} catch (JsonMappingException e) {
			logger.error("Failed to read json with message: " + e.getMessage());
			return null;
		} catch (IOException e) {
			logger.error("Failed to read json with message: " + e.getMessage());
			return null;
		}
	}
}
