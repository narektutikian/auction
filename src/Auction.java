import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


public class Auction implements Runnable{

    private String AuctionID;
    private GregorianCalendar StartDate = new GregorianCalendar();
    private GregorianCalendar EndDate;
    private String State = "active";
    private int SellerID;
    private Double InitialPrice;
    private Double MinBidPrice;
    private Double BuyItNowPrice;
    private volatile Double CurrentPrice;
    private Double bidprice;
    private Boolean run = false;
    private ArrayList<Bid> bids = new ArrayList<Bid>();

    public Auction(GregorianCalendar newEndDate, int newSellerID, Double newInitialPrice, Double newMinBidPrice,
                   Double newBuyItNowPrice) {
        EndDate = newEndDate;
        SellerID = newSellerID;
        InitialPrice = newInitialPrice;
        MinBidPrice = newMinBidPrice;
        BuyItNowPrice = newBuyItNowPrice;
        CurrentPrice = newInitialPrice;
    }

    private Boolean ChekBidder(int BidderID){
        if (this.SellerID != BidderID)
            return true;
        else return false;
    }

    private Boolean CheckDate() {
        GregorianCalendar currentdate = new GregorianCalendar();
        if (currentdate.before(EndDate))
            return true;
        else
            return false;
    }

    private void setBidprice(Double NewBidprice) {
        bidprice = NewBidprice;
    }

    public void run(){
        try {
            bid();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private synchronized void bid() throws InterruptedException{
        if (run)
            CurrentPrice += bidprice;

    }

    public Boolean setBid(Double bidPreice, int bidderID) {
        if (ChekBidder(bidderID) & CheckDate()) {
            Bid newBid = new Bid(this.AuctionID, bidderID, bidPreice);
            bids.add(newBid);
            setBidprice(bidPreice);
            run = true;
            return true;
        }
        else return false;
    }

    public String getAuctionID(){
        return AuctionID;
    }
    public Double getCurrentPrice(){return CurrentPrice;}


}
