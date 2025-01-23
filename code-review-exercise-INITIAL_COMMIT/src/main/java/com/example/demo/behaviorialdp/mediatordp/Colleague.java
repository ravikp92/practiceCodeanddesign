package src.main.java.com.example.demo.behaviorialdp.mediatordp;

public interface Colleague {

    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getBidderName();
}
