

class User {

    private String FullName, Addres, Contact, Email, Password;
    private int UserID;
    private Double Rateing;


    public User (String newFullName, String newAddres, String newContact, String newEmail,  String newPassword, int newUserID){
        FullName = newFullName;
        Addres = newAddres;
        Contact = newContact;
        Email = newEmail;
        Password = newPassword;
        Rateing = .0;
        UserID = newUserID;
    }

    public int getUserID(){
        return UserID;
    }

    public boolean Bid(Double newBid, Auction auction){
        // get auction which Id = AuctionID
        if (auction.setBid(newBid, this.UserID))
            return true;
        else return false;

    }
}
