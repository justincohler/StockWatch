package com.stockwatch.service;

/**
 * 
 * @author justincohler
 *
 *         EmailService is used to shoot emails to a user list when a trading
 *         strategy finds a relevant stock for bid/ask
 */
public interface EmailService {
	
	public boolean sendEmail(String subject, String text);

}
