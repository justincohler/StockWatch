package com.stockwatch.service.impl;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stockwatch.service.EmailService;

public class EmailServiceImpl implements EmailService, Serializable {
	private static final long serialVersionUID = -6757771051618142131L;

	final static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	private static final String EMAIL_TO = "justincohler@gmail.com";
	private static final String EMAIL_FROM = "justincohler@gmail.com";
	private static final String EMAIL_USERNAME = "justincohler@gmail.com";
	private static final String EMAIL_PASSWORD = "vychsevrxcjfpoxt";
	private static final String EMAIL_HOST = "smtp.gmail.com";
	private static final String EMAIL_PORT = "587";

	public boolean sendEmail(String subject, String text) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", EMAIL_HOST);
		props.put("mail.smtp.port", EMAIL_PORT);

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL_FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

			logger.info("Sent message with subject: " + subject);
			return true;

		} catch (Exception e) {
			logger.error("Failed to send message with subject: " + subject);
			logger.error("Failed with message: " + e.getMessage());
			return false;
		}
	}

}
