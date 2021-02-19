package javaCode;

import javafx.scene.control.Button;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Users {

    Database database = new Database();
    // ============================== CONSTRUCTOR ==============================
    public Users() {}

    public Database getDatabase() {
        return database;
    }

    public void LoginToSystem()
    {
        String salt = "1768f17d8686ce105b4b58def546bbee39e86eb8b5f5860a3cc7e72cac72315cb4d7abe5cf513e201b3e0c44cfe8fda436ad877e91c6806644b1d609382a83dd";
    }

    public void CreateUser(String fName, String sName, String username, String password, String confirmPassword, boolean technician, Button btnMenu) throws NoSuchAlgorithmException
    {
        boolean duplicateUsername = database.CheckUsersNotDuplicate(username);
        boolean confirmedPass = ConfirmPassword(password, confirmPassword);

        if (duplicateUsername == false && confirmedPass == false)
        {
            String salt = "1768f17d8686ce105b4b58def546bbee39e86eb8b5f5860a3cc7e72cac72315cb4d7abe5cf513e201b3e0c44cfe8fda436ad877e91c6806644b1d609382a83dd";
            String hashedPassword = get_SHA_512_SecurePassword(password, salt);
            database.AddUsers(fName, sName, username, technician, hashedPassword);
            JOptionPane.showMessageDialog (null, "User successfully added", "User added", JOptionPane.INFORMATION_MESSAGE);
            btnMenu.fire();

        }

        else
        {
            JOptionPane.showMessageDialog (null, "User not added, username already in use.", "User not added", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean ConfirmPassword(String password, String cPassword)
    {
        if (password.equals(cPassword))
        {
            return true;
        }
        else {
            return false;
        }
    }

    public String get_SHA_512_SecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
