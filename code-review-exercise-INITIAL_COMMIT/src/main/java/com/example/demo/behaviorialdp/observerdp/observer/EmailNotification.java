package com.example.demo.behaviorialdp.observerdp.observer;

import com.example.demo.behaviorialdp.observerdp.observable.StockObservable;

public class EmailNotification implements NotifyMeObserver{

    //used strategy pattern for stockobservable
    StockObservable stockObservable;
    String emailId;

    public EmailNotification(String emailId,StockObservable stockObservable){
        this.emailId=emailId;
        this.stockObservable=stockObservable;
    }
    @Override
    public void update() {
        sendMail(emailId,"Stock is available ..Hurry up!!");
    }

    private void sendMail(String username, String s) {
        System.out.println("email sent to user emailId "+emailId);
    }
}
