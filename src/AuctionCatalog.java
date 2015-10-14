/*dsdsd*/
import java.util.LinkedList;
import java.util.UUID;

/**
 * Created by Zara on 10/6/2015.
 */
public class AuctionCatalog {
    LinkedList<Auction> auctions = new LinkedList<Auction>();

    public Auction getAuction(UUID auctionID){
        Auction temp = null;
        for (Auction a : auctions){
            if (a.getAuctionID()== auctionID)
                temp = a;
        }
        return temp;
    }

    public void addAuction(Auction auction){
        auctions.add(auction);
    }

    public void removeAuction(Auction auction){
        auctions.remove(auction);
    }
}
