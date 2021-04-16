package javaCode;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.bson.Document;
import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Users {

    // ============================== VARIABLES ==============================
    Database database = new Database();

    // ============================== CONSTRUCTOR ==============================
    public Users() {}

    // ============================== GETTERS ==============================
    public Database getDatabase() {
        return database;
    }

    //Logs user into the system, sending them to appropriate menu
    public String LoginToSystem(String username, String password, boolean technician, boolean admin)
    {
        String salt = "1768f17d8686ce105b4b58def546bbee39e86eb8b5f5860a3cc7e72cac72315cb4d7abe5cf513e201b3e0c44cfe8fda436ad877e91c6806644b1d609382a83dd";
        String hashedPassword = get_SHA_512_SecurePassword(password, salt);

    boolean realUser = LoginToSystem(username, hashedPassword);
    String guiType = null;
    if(realUser)
    {
        if (technician) {guiType = "../fxmlCode/TechnicianMainMenuGUI.fxml";}
        else if (admin) {guiType = "../fxmlCode/AdminMainMenuGUI.fxml";}
        else            {guiType = "../fxmlCode/CustomerMainMenuGUI.fxml";}
    }

    return guiType;
    }

    public void CreateUser(String fName, String sName, String username, String password, String confirmPassword, boolean technician, Button btnMenu) {
        boolean duplicateUsername = CheckUsersNotDuplicate(username);
        boolean confirmedPass = ConfirmPassword(password, confirmPassword);

        if (!duplicateUsername & confirmedPass)
        {
            String salt = "1768f17d8686ce105b4b58def546bbee39e86eb8b5f5860a3cc7e72cac72315cb4d7abe5cf513e201b3e0c44cfe8fda436ad877e91c6806644b1d609382a83dd";
            String hashedPassword = get_SHA_512_SecurePassword(password, salt);
            AddUsers(fName, sName, username, technician, hashedPassword);
            JOptionPane.showMessageDialog (null, "User successfully added", "User added", JOptionPane.INFORMATION_MESSAGE);
            btnMenu.fire();
        }

        else
        {
            JOptionPane.showMessageDialog (null, "User not added, username already in use.", "User not added", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Makes sure password is the same when creating new account.
    public boolean ConfirmPassword(String password, String cPassword)
    {
        return password.equals(cPassword);
    }

    //Encryption of password.
    public String get_SHA_512_SecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    //Checks if user is a technician or admin. does this by checking if the technician field and admin field are true in the database.
    public boolean userTypeCheck(String username, int idNum)
    {
        boolean userType = false;

        label:
        try {
            MongoCollection<Document> col = getDatabase().GetDatabase().getCollection("Accounts");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(3)) && list.get(idNum).equals(true)) {
                    userType = true;
                    break label;
                }
            }
        } catch (Exception e) {System.out.println(e);}
        return userType;
    }

    //Displays users to the admin
    public void displayUsers(ListView lstUsers) {
        try {
            MongoCollection<Document> col = getDatabase().GetDatabase().getCollection("Accounts");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                lstUsers.getItems().add("Name: " + list.get(1) + " " + list.get(2) + ", Username: " + list.get(3) + ", Technician: " + list.get(5).toString());
            }
        } catch (Exception e) {System.out.println(e);}
    }

    //Checks to see if username and password is same as stored username and password
    public boolean LoginToSystem(String username, String password) {
        boolean validLogin = false;
        try {
            MongoCollection<Document> col = getDatabase().GetDatabase().getCollection("Accounts");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(3)) && password.equals(list.get(4))) {
                    validLogin = true;
                    break;
                }
            }
        } catch (Exception e){System.out.println(e);}
        return validLogin;
    }



    //Checks for duplicate usernames
    public boolean CheckUsersNotDuplicate(String username) {
        boolean duplicate = false;
        try {
            MongoCollection<Document> col = getDatabase().GetDatabase().getCollection("Accounts");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (list.get(3).equals(username)) {
                    duplicate = true;
                    break;
                }
            }
        } catch (Exception e) {System.out.println(e);}
        return duplicate;
    }

    //Allows admin to add users to database.
    public void AddUsers(String fName, String sName, String username, boolean technician, String hashedPassword)
    {
        MongoCollection<Document> col = getDatabase().GetDatabase().getCollection("Accounts");
        Document user = new Document
                ("F_Name", fName).append
                ("S_Name", sName).append
                ("U_Name", username).append
                ("pass", hashedPassword).append
                ("Technician", technician).append
                ("Admin", "false");
        col.insertOne(user);
    }

    //Allows user to remove users from database.
    public void RemoveUsers(String username)
    {
        try
        {
            MongoCollection<Document> col = getDatabase().GetDatabase().getCollection("Accounts");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(3))) {
                    col.deleteOne(Filters.eq("U_Name", username));
                    break;
                }
            }
        }
        catch (Exception e) {System.out.println(e);}
    }
}
