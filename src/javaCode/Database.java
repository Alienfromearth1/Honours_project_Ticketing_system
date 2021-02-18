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
    public Database(){
        //Stops console spam from MongoDB
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);
    }

    public void LoadPreviousTickets(ListView lstPreviousTicket)
    {
        try
        {
            MongoCollection<Document> col = database.getCollection("Tickets");
            MongoCursor<Document> cur = col.find().iterator();
            while (cur.hasNext())
            {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                lstPreviousTicket.getItems().add(list.get(1));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
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
        MongoCollection<Document> col = database.getCollection("Accounts");
        col.deleteOne(Filters.eq("U_Name", username));
    }

}
