

public class User {

    private String FullName, Address, Contact, Email, Password;
    private int UserID;
    private double Rating;


    public User (String newFullName, String newAddress, String newContact, String newEmail,  String newPassword, int newUserID){
        FullName = newFullName;
        Address = newAddress;
        Contact = newContact;
        Email = newEmail;
        Password = newPassword;
        Rating = .0;
        UserID = newUserID;
    }

    public int getUserID(){
        return UserID;
    }
    public double getRating(){
        return Rating;
    }

    public boolean Bid(Double newBid, Auction auction){
        // get auction which Id = AuctionID
        if (auction.setBid(newBid, this.UserID))
            return true;
        else return false;

    }
}
