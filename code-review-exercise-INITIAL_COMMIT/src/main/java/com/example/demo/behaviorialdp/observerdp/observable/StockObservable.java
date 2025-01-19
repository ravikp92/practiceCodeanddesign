package src.main.java.com.example.demo.behaviorialdp.observerdp.observable;

import src.main.java.com.example.demo.behaviorialdp.observerdp.observer.NotifyMeObserver;

public interface StockObservable {

    void add(NotifyMeObserver notifyMeObserver);

    void remove(NotifyMeObserver notifyMeObserver);

    void notifyAllSubscribers();

    void setStockCount(int count);

    int getCount();
}
