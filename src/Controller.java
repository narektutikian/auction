
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Created by King on 9/26/2015.
 */
public class   Controller {

    public static void main(String args[]){

        ListofUsers users = new ListofUsers();
        users.addUser("01","B1","9405", "asd@bn.com", "pass");
        users.addUser("02","B1","9405", "asd@bn.com", "pass");
        users.addUser("03","B1","9405", "asd@bn.com", "pass");
        users.addUser("04","B1","9405", "asd@bn.com", "pass");
        users.addUser("05","B1","9405", "asd@bn.com", "pass");
        users.addUser("06","B1","9405", "asd@bn.com", "pass");
        users.addUser("07","B1","9405", "asd@bn.com", "pass");
        users.addUser("08","B1","9405", "asd@bn.com", "pass");
        users.addUser("09","B1","9405", "asd@bn.com", "pass");
        users.addUser("10","B1","9405", "asd@bn.com", "pass");
        users.addUser("11","B1","9405", "asd@bn.com", "pass");

        Date current = new Date();
        Date EndDate = new Date();
        EndDate.setTime(current.getTime()+ 50000);
        Auction pic = new Auction(EndDate, 1, 10, 1,1000);
        int i = 0;
        Random index = new Random();

        while (true){
            System.out.println("Current Price is " + pic.getCurrentPrice());
            if (users.users.get(i).Bid(1.5, pic)) {
                Thread t = new Thread(pic);
                t.start();
            }
            try {
                TimeUnit.SECONDS.sleep(2);}
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("After bid with uid " + users.users.get(i).getUserID() + " Current Price is "+ pic.getCurrentPrice()+"\n");
                i = index.nextInt(11);

        }

    }



}
