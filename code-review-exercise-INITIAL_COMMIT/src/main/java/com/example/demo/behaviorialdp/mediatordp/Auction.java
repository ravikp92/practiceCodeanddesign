package src.main.java.com.example.demo.behaviorialdp.mediatordp;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{

    List<Colleague> colleagues=new ArrayList<>();


    @Override
    public void addBidder(Colleague bider) {
        colleagues.add(bider);
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {

        for(Colleague colleague:colleagues){
            if(!colleague.getBidderName().equals(bidder.getBidderName())){
                colleague.receiveBidNotification(bidAmount);
            }
        }
    }
}
