package com.company;

public class Main {

    public static void main(String[] args) throws NoTransportException {
    EmailNotification emailNotification = new EmailNotification("this is subject","this is body","zach","ATT");
    TextNotification textNotification = new TextNotification("txt subject","txt body","sam","Verizon");

    emailNotification.transport();
    emailNotification.status = "changed status";
    emailNotification.showStatus();
        System.out.println("\n");
    textNotification.transport();
    textNotification.showStatus();

    }
}
