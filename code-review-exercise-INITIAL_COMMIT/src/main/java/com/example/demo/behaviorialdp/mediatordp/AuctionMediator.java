package src.main.java.com.example.demo.behaviorialdp.mediatordp;

public interface AuctionMediator {

    void addBidder(Colleague bider);
    void placeBid(Colleague bidder, int bidAmount);

}
