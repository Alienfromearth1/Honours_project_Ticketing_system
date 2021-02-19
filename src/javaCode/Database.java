package javaCode;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import javafx.scene.control.ListView;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    MongoClientURI uri = new MongoClientURI("mongodb+srv://W_Reynolds:PQ8L56AIqd0CR1mL@cluster0.t60r7.mongodb.net/TicketingSystem?retryWrites=true&w=majority");
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("TicketingSystem");

    // ============================== CONSTRUCTOR ==============================
    public Database() {
        //Stops console spam from MongoDB
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
    }

    //Checks if user is a technician or admin. does this by checking if the technician field and admin field are true in the database.
    public boolean userTypeCheck(String username, int idNum)
    {
        boolean userType = false;

        label:
        try {
            MongoCollection<Document> col = database.getCollection("Accounts");
            MongoCursor<Document> cur = col.find().iterator();
            while (cur.hasNext()) {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(3)) && list.get(idNum).equals(true))
                {
                    System.out.println(idNum);
                    userType = true;
                    break label;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return userType;
    }

    public void CheckIfAdmin(String username)
    {

    }


    public boolean LoginToSystem(String username, String password) {
        boolean validLogin = false;

        label:
        try {
            MongoCollection<Document> col = database.getCollection("Accounts");
            MongoCursor<Document> cur = col.find().iterator();
            while (cur.hasNext()) {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(3)) && password.equals(list.get(4)))
                {
                    validLogin = true;
                    break label;
                }
                else
                {
                    validLogin = false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validLogin;
    }














    public void LoadPreviousTickets(ListView lstPreviousTicket) {
        try {
            MongoCollection<Document> col = database.getCollection("Tickets");
            MongoCursor<Document> cur = col.find().iterator();
            while (cur.hasNext()) {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                lstPreviousTicket.getItems().add(list.get(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void LoadUsers(ListView lstUsers) {
        try {
            MongoCollection<Document> col = database.getCollection("Accounts");
            MongoCursor<Document> cur = col.find().iterator();
            while (cur.hasNext()) {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                lstUsers.getItems().add(list.get(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean CheckUsersNotDuplicate(String username) {
        boolean duplicate = false;
        try {
            MongoCollection<Document> col = database.getCollection("Accounts");
            MongoCursor<Document> cur = col.find().iterator();

            while (cur.hasNext())
            {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                if (list.get(3).equals(username))
                {
                    duplicate = true;
                    break;
                }
                else
                    {
                    duplicate = false;
                    }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return duplicate;
    }

    public void AddUsers(String fName, String sName, String username, boolean technician, String hashedPassword)
    {
        MongoCollection<Document> col = database.getCollection("Accounts");
        Document user = new Document
                ("F_Name", fName).append
                ("S_Name", sName).append
                ("U_Name", username).append
                ("pass", hashedPassword).append
                ("Technician", technician).append
                ("Admin", "false");
        col.insertOne(user);
    }

    public void RemoveUsers(String username)
    {
        try
        {
            MongoCollection<Document> col = database.getCollection("Accounts");
            MongoCursor<Document> cur = col.find().iterator();
            while (cur.hasNext())
            {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                if(username.equals(list.get(3)))
                {
                    col.deleteOne(Filters.eq("U_Name", username));
               break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
