package com.company;

/**
 * Created by Zach on 7/19/17.
 */
public class EmailNotification extends Notification {
    private String recipient;
    private String smtpProvider;

    public EmailNotification(String subject, String body, String recipient, String smtpProvider) {
        super(subject, body);
        this.recipient = recipient;
        this.smtpProvider = smtpProvider;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSmtpProvider() {
        return smtpProvider;
    }

    @Override
    public void transport() throws NoTransportException {
        System.out.printf("recipient: %s\nsmtpProvider: %s\nsubject: %s\nbody: %s\n",recipient,smtpProvider,getSubject(),getBody());
    }
}
