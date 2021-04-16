package javaCode;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    //Gets the database from mongoDB
    private final MongoClientURI uri = new MongoClientURI("mongodb+srv://W_Reynolds:PQ8L56AIqd0CR1mL@cluster0.t60r7.mongodb.net/TicketingSystem?retryWrites=true&w=majority");
    private final MongoClient mongoClient = new MongoClient(uri);
    private final MongoDatabase database = mongoClient.getDatabase("TicketingSystem");

    // ============================== CONSTRUCTOR ==============================
    public Database() {
        //Stops console spam from MongoDB
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
    }

    //getter for database
    public MongoDatabase GetDatabase() {return database;}
}
