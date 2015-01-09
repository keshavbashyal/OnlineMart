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

    public void sendRegistrationEmail(String recipient, String fname, String lname) {
        String subject = "Welcome to Online Mart";
        String message = "<h3>Dear,<br/>"
                + fname + " " + lname + "</h3><br/>"
                + "Thank you for registering at OnlineMart.<br/>"
                + "We hope you will find the best items at the lowest price on Internet.<br/>"
                + "Our Customer Service is there to help you 24-7, 365 days a year<br/>"
                + "Please use the contact link on the website if you have any concerns or queries."
                + "Happy Shopping,<br/>"
                + "Online Mart Team";
        sendEmail(recipient, subject, message);
    }

    public void sendVendorSignUpEmail(String recipient, String fname) {
        String subject = "Registration for your company "+fname;
        String message = "<h3>Greetings,<br/>"
                + "Thank you for registering at OnlineMart.<br/>"
                + "We are the best online retail mart in the planet<br/>"
                + "Please wait for an email from our team while we go ahead and prepare the best<br/>"
                + "platform for your retail shop<br/>"
                + "Our team will send you an email shortly after you are approved<br/>"
                + "You will then be able to login and advertise your products.<br/>"
                + "Our Customer Service is there to help you 24-7, 365 days a year<br/>"
                + "Please use the contact link on the website if you have any concerns or queries."
                + "Happy Shopping,<br/>"
                + "Online Mart Team";
        sendEmail(recipient, subject, message);
    }

    public void sendVendorSuccessEmail(String recipient, String fname) {
        String subject = "Registration for your company " + fname;
        String message = "<h3>Greetings,<br/>"
                + "Thank you for registering at OnlineMart.<br/>"
                + "Your account is verified and you may now login<br/>"
                + "Our Customer Service is there to help you 24-7, 365 days a year<br/>"
                + "Please use the contact link on the website if you have any concerns or queries."
                + "Happy Shopping,<br/>"
                + "Online Mart Team";
        sendEmail(recipient, subject, message);
    }
}
