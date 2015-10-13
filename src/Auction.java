/*awesome*/
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Bool;


import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


public class Auction implements Runnable{

    private UUID AuctionID;
    private Date StartDate = new Date();
    private Date EndDate;
    private String State = "active";
    private int SellerID;
    private double InitialPrice;
    private double MinBidPrice;
    private double BuyItNowPrice;
    private volatile Double CurrentPrice;
    private double bidprice;
    private String auctionID;
    private Boolean run = false;
    private ArrayList<Bid> bids = new ArrayList<Bid>();

    public Auction(Date newEndDate, int newSellerID, double newInitialPrice, double newMinBidPrice,
                   double newBuyItNowPrice) {
        EndDate = newEndDate;
        SellerID = newSellerID;
        InitialPrice = newInitialPrice;
        MinBidPrice = newMinBidPrice;
        BuyItNowPrice = newBuyItNowPrice;
        CurrentPrice = newInitialPrice;
        AuctionID = UUID.randomUUID();

    }

    private Boolean CheckBidder(int BidderID){
        if (this.SellerID != BidderID)
            return true;
        else return false;
    }

    private Boolean CheckDate() {
        Date currentDate = new Date();
        int result = currentDate.compareTo(EndDate);
        if(result > 0){
            System.out.println("Auction date is out");
            return false;}
        else
            System.out.println("Current Date:" + currentDate +"\n"+ "End Date:" + EndDate );
        return true;
    }

    private void setBidprice(double NewBidprice) {
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

    public Boolean setBid(double bidPrice, int bidderID) {
        if (CheckBidder(bidderID) & CheckDate()) {
            Bid newBid = new Bid(this.AuctionID, bidderID, bidPrice);
            bids.add(newBid);
            setBidprice(bidPrice);
            run = true;
            return true;
        }
        else return false;
    }

    public UUID getAuctionID(){
        return AuctionID;
    }
    public double getCurrentPrice(){return CurrentPrice;}


}
