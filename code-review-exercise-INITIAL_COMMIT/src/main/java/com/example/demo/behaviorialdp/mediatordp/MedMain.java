package src.main.java.com.example.demo.behaviorialdp.mediatordp;

public class MedMain {
    public static void main(String[] args) {

        AuctionMediator auctionMediator=new Auction();
        Bidder a= new Bidder("A",auctionMediator);
        Bidder b= new Bidder("B",auctionMediator);

        a.placeBid(100);
        b.placeBid(200);

    }
}
