package com.example.demo.behaviorialdp.observerdp;

import com.example.demo.behaviorialdp.observerdp.observable.IphoneObservable;
import com.example.demo.behaviorialdp.observerdp.observable.StockObservable;
import com.example.demo.behaviorialdp.observerdp.observer.EmailNotification;
import com.example.demo.behaviorialdp.observerdp.observer.MobileNotification;
import com.example.demo.behaviorialdp.observerdp.observer.NotifyMeObserver;

public class StoreMain {

    public static void main(String[] args) {
        StockObservable iphoneStockObserve=new IphoneObservable();

        NotifyMeObserver observer1=new EmailNotification("c@gmai.com",iphoneStockObserve);
        NotifyMeObserver observer2=new MobileNotification("78820123",iphoneStockObserve);

        iphoneStockObserve.add(observer1);
        iphoneStockObserve.add(observer2);


        iphoneStockObserve.setStockCount(0); // no notification
        iphoneStockObserve.setStockCount(10); //notfication

    }
}
