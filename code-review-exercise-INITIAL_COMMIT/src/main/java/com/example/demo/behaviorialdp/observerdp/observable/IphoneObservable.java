package com.example.demo.behaviorialdp.observerdp.observable;

import com.example.demo.behaviorialdp.observerdp.observer.NotifyMeObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable{

    List<NotifyMeObserver> notifyMeObserverListForIphone=new ArrayList<>();
    public int iphoneCount=0;

    @Override
    public void add(NotifyMeObserver notifyMeObserver) {
        notifyMeObserverListForIphone.add(notifyMeObserver);
    }

    @Override
    public void remove(NotifyMeObserver notifyMeObserver) {
        notifyMeObserverListForIphone.remove(notifyMeObserver);
    }

    @Override
    public void notifyAllSubscribers() {
        notifyMeObserverListForIphone.forEach(notifyMeObserver -> notifyMeObserver.update());
    }

    @Override
    public void setStockCount(int count) {
        if(count!=0){
            notifyAllSubscribers();
        }
        iphoneCount+=count;
    }

    @Override
    public int getCount() {
        return iphoneCount;
    }
}
