import java.util.ArrayList;

/**
 * Created by King on 9/26/2015.
 */
public class ListofUsers {

    ArrayList<User> users = new ArrayList<User>();
    int UserIDs = 0;

    public User getUser(int UserID) {
        User temp = null;
        for (User u : users){
            if (u.getUserID()== UserID)
                temp = u;
        }
        return temp;
    }

    public int addUser(String newFullName, String newAddress, String newContact, String newEmail,  String newPassword){
        int userID = UserIDs;
        User newUser = new User (newFullName, newAddress, newContact, newEmail,  newPassword, userID);
                UserIDs++;
        users.add(newUser);
        return userID;
    }

    public void removeUser(User user){
        users.remove(user);
    }
}
