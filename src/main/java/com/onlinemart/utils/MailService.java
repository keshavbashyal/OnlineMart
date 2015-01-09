/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.utils;

/**
 *
 * @author s_paw_000
 */
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    private static final String username = "onlinemartcustomercare@gmail.com";
    private static final String password = "onlinemar";

    public static void sendEmail(String to, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
 
			MimeMessage message = new MimeMessage(session);
                        
			message.setFrom(new InternetAddress("onlinemartcustomercare@gmail.com"));
			message.setRecipients(MimeMessage.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);
                        
                        message.setContent(body, "text/html; charset=utf-8");
                        message.saveChanges();
                        
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
    public void sendRegistrationEmail(String recipient, String fname, String lname ){
        String subject = "Welcome to Online Mart";
        String message = "<h3>Dear</h3><br/>"
                + "<h3>"+fname + " " + lname + "</h3><br/>"
                + "<br/>"
                + "Thank you for registering at OnlineMart.<br/>"
                + "Happy Shopping<br/>"
                + "<br/>"
                + "Online Mart Team";
        sendEmail(recipient,subject,message);
    }
    
}