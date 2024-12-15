package com.example.demo.behaviorialdp.observerdp.observer;

import com.example.demo.behaviorialdp.observerdp.observable.StockObservable;

public class MobileNotification implements NotifyMeObserver {

    StockObservable stockObservable;
    String mobile;

    public MobileNotification(String mobile,StockObservable stockObservable){
        this.mobile=mobile;
        this.stockObservable=stockObservable;
    }

    @Override
    public void update() {
        sendMessageToMobile(mobile,"Hurry up !! stock is up!!");
    }

    private void sendMessageToMobile(String mobile, String s) {
        System.out.println("Message sent to mobile"+mobile);
    }
}
