package src.main.java.com.example.demo.behaviorialdp.mediatordp;

public class Bidder implements Colleague{

    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        this.auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        auctionMediator.placeBid(this,bidAmount);

    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println("Bidder " + name + "got notification of amount bidded by other person "+ bidAmount);
    }

    @Override
    public String getBidderName() {
        return name;
    }
}
