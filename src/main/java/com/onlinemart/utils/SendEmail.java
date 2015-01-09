/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.utils;
import java.util.Properties;
import javax.ejb.Asynchronous;
//import javax.ejb.Stateless;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author GirmaGuta
 */
public class SendEmail {
    
    private static final String HOST = "smtp.gmail.com"; // mail servaer provider which is gmail.
    private static final int PORT = 465; //  mailserver provider port.
    private static final String USER = "onlinemartcustomercare";     // Must be valid user from gmail account 
    private static final String PASSWORD = "onlinemar"; // Must be valid password 
    private static final String FROM = "onlinemartcustomercare@gmail.com"; // gmail email account.
    private static SendEmail emailService = null;
    private static Session mailSession;

    public SendEmail() {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", HOST);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.from", FROM);
        props.put("mail.smtps.quitwait", "false");

        mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
    }
    
    public  void sendEmail(String recipient, String subject, String message) throws MessagingException {

        if ( emailService == null ) {
            emailService = new SendEmail();
        }

        MimeMessage mimeMessage = new MimeMessage(mailSession);

	mimeMessage.setFrom(new InternetAddress(FROM));
	mimeMessage.setSender(new InternetAddress(FROM));
	mimeMessage.setSubject(subject);
        mimeMessage.setContent(message, "text/plain");

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        Transport transport = mailSession.getTransport("smtps");
        System.out.println("connecting ....");
        transport.connect(HOST, PORT, USER, PASSWORD);
        System.out.println("connected..............");
        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        System.out.println("sent............");
        transport.close();

    }
    
    public  void sendRegistrationEmail(String recipient, String fname, String lname) throws MessagingException {

        if ( emailService == null ) {
            emailService = new SendEmail();
        }

        MimeMessage mimeMessage = new MimeMessage(mailSession);

	mimeMessage.setFrom(new InternetAddress(FROM));
	mimeMessage.setSender(new InternetAddress(FROM));
        String subject = "Welcome to Online Mart";
        String message = "<h3>Dear</h3><br/>"
                + "<h3>"+fname + " " + lname + "</h3><br/>"
                + "<br/>"
                + "Thank you for registering at OnlineMart.<br/>"
                + "Happy Shopping<br/>"
                + "<br/>"
                + "Online Mart Team";
	mimeMessage.setSubject(subject);
        mimeMessage.setContent(message, "text/html; charset=utf-8");

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

        Transport transport = mailSession.getTransport("smtps");
        System.out.println("connecting ....");
        transport.connect(HOST, PORT, USER, PASSWORD);
        System.out.println("connected..............");
        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        System.out.println("sent............");
        transport.close();

    }

}
