package com.company;

/**
 * Created by Zach on 7/19/17.
 */
public class TextNotification extends Notification {
    private String recipient;
    private String smsProvider;


    public TextNotification(String subject, String body, String recipient, String smsProvider) {
        super(subject, body);
        this.recipient = recipient;
        this.smsProvider = smsProvider;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSmsProvider() {
        return smsProvider;
    }

    @Override
    public void transport() throws NoTransportException {
        System.out.printf("recipient: %s\nsmtpProvider: %s\nsubject: %s\nbody: %s\n",recipient,smsProvider,getSubject(),getBody());
    }
}
