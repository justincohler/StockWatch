package com.stockwatch.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stockwatch.service.impl.EmailServiceImpl;

public class EmailServiceTest {

	@Test
	public void testSendEmail() {
		
		String subject = "Justin, it's me, Justin!";
		String message = "Hey, our email service is working!";
		
		EmailService service = new EmailServiceImpl();
		boolean result = service.sendEmail(subject, message);
		
		assertEquals(true, result);
	}

}
