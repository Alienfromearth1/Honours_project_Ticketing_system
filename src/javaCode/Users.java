package javaCode;

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

    public void CreateUser(String fName, String sName, String username, String password, boolean technician) throws NoSuchAlgorithmException {
        String salt = "1768f17d8686ce105b4b58def546bbee39e86eb8b5f5860a3cc7e72cac72315cb4d7abe5cf513e201b3e0c44cfe8fda436ad877e91c6806644b1d609382a83dd";
        String hashedPassword = get_SHA_512_SecurePassword(password, salt);
        database.AddUsers(fName, sName, username,technician, hashedPassword);
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
