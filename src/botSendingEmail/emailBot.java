package botSendingEmail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sae.Film;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class emailBot {
	
	private String recepient;
	private String subject;
	private String contentMessage;
	
	
	private static final String DEFAULT_SUBJECT = "NO_SUBJECT";
	private static final String DEFAULT_CONTENT_MESSAGE = "NO_MESSAGE";
	
	
	// Info de l'envoyeur
	private static final String accountEmailSender = "XXXXXX@gmail.com";
	private static final String passwordEmailSender = "XXXXXXXXXXXXXXX";
	
	
	public emailBot(String recepient, String subject, String contentMessage) {
		this.recepient = recepient;
		this.subject = subject;
		this.contentMessage = contentMessage;
	}
	
	public emailBot(String recepient) {
		this(recepient, DEFAULT_SUBJECT, DEFAULT_CONTENT_MESSAGE);
	}

	public void sendMail() throws MessagingException {
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com"); //smtp-relay.gmail.com
		properties.put("mail.smtp.port", "587");
 
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(accountEmailSender, passwordEmailSender);
			}
		});
		
		
		Address internetAdress = new InternetAddress(accountEmailSender);
		Address internetAdressRecepient = new InternetAddress(getRecepient());

		
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(internetAdress);
		message.addRecipient(Message.RecipientType.TO, internetAdressRecepient);
		
		message.setSubject(getSubject());
		message.setText(getContentMessage());
		
		
		Transport.send(message);
		
		
		System.out.println("Message envoyer à  : "+getRecepient());
		System.out.println("Résumer du message : ");
		System.out.print(getContentMessage());
		
	}

	
	//Getters
	
	public String getRecepient() {
		return recepient;
	}

	public String getSubject() {
		return subject;
	}

	public String getContentMessage() {
		return contentMessage;
	}
	
}
