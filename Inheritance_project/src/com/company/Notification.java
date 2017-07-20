package com.company;

import java.time.LocalDateTime;

/**
 * Created by Zach on 7/19/17.
 */
public class Notification {
    private LocalDateTime createdAt;
    private String subject;
    private String body;
    protected String status = "status good";

    public Notification(String subject, String body) {
        this.subject = subject;
        this.body = body;
        this.createdAt = LocalDateTime.now();
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void transport() throws NoTransportException {
        throw new NoTransportException();
    }

    public void showStatus(){
        System.out.println("Current status is: " + status);
    }
}
