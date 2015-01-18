/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjavamailapidemo;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author NawazishMohammad
 */
public class MyAuthenticator extends Authenticator{
    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication("senderEmail@gmail.com", "senderEmailPassword");
    }
}
