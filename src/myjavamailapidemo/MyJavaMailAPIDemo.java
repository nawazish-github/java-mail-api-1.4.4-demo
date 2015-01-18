/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjavamailapidemo;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author NawazishMohammad
 */
public class MyJavaMailAPIDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Trying to send email");
        String senderEmail = "senderEmail@gmail.com";
        String recepientEmail = "receiverEmail@gmail.com";
        Properties emailConfigs = new Properties ();
        emailConfigs.setProperty("mail.store.protocol", "smtp"); 
        emailConfigs.setProperty("mail.transport.protocol", "smtp");
        emailConfigs.setProperty("mail.host", "smtp.gmail.com");
        emailConfigs.setProperty("mail.user", "senderEmail@gmail.com");
        emailConfigs.setProperty("mail.from", "senderEmail@gmail.com");
        emailConfigs.setProperty("mail.smtp.starttls.enable", "true");
        emailConfigs.setProperty("mail.smtp.password", "senderEmailPassword");
        emailConfigs.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(emailConfigs, new MyAuthenticator());
        
        MimeMessage msg = new MimeMessage(session);
        try {
           
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepientEmail));
            msg.setSubject("Subject JavaMail API Demo Email");
            msg.setSentDate(new Date());
            msg.setText("JavaMail API Body Message");
            Transport.send(msg);
            System.out.println("email send successfully");
        } catch (MessagingException ex) {
            System.out.println("inside catch block");
            ex.printStackTrace();
            Logger.getLogger(MyJavaMailAPIDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
