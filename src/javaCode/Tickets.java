package javaCode;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private final Users users = new Users();

    // ============================== CONSTRUCTOR ==============================
    public Tickets(){}

    // ============================== GETTERS ==============================
    public Users getUsers() {
        return users;
    }


    //Loads the information of a ticket which has been selected by a technician.
    public String getOngoingTicketInfo(String username, Label lblInformation, Label lblCustomer, Label lblTechnician)
    {
        String image = "";
        try {
            MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OngoingTickets");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(1))) {
                    //Puts information on screen
                    lblInformation.setText(list.get(3).toString());
                    lblTechnician.setText("Technician: " + list.get(2).toString());
                    lblCustomer.setText("User: " + list.get(1).toString());
                    image = list.get(1).toString();
                    break;
                } else if (username.equals(list.get(2).toString())) {
                    //Puts information on screen
                    lblInformation.setText(list.get(3).toString());
                    lblTechnician.setText("Technician: " + list.get(2).toString());
                    lblCustomer.setText("User: " + list.get(1).toString());
                    image = list.get(1).toString();
                    break;
                }
            }
        } catch (Exception e) {System.out.println(e);}
        return image;
    }

    //Displays basic information of previous tickets in the system.
    public void LoadPreviousTickets(ListView lstPreviousTicket) {
        try {
            MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("Tickets");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                lstPreviousTicket.getItems().add("User submitting: " + list.get(1) + ", Ticket solved by: " + list.get(2) + ", Issue: " + list.get(3) + ", Notes: " + list.get(4));
            }
        } catch (Exception e) {System.out.println(e);}
    }

    //Displays tickets which havent been selected by a technician
    public void LoadOpenTickets(ListView lstPreviousTicket) {
        try {
            MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OpenTickets");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                lstPreviousTicket.getItems().add("User: " + list.get(1) + " Issue: " + list.get(2));
            }
        } catch (Exception e) {System.out.println(e);}
    }

    //checks to see if the user has a ticket created or in progress.
    public boolean CheckIfHasTicket(String username, int id) {
        boolean duplicate = false;
        try {
            MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OngoingTickets");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (list.get(id).equals(username)) {
                    duplicate = true;
                    break;
                }
            }
        } catch (Exception e) {System.out.println(e);}
        return duplicate;
    }

    //checks to see if the user has a ticket created or in progress.
    public boolean CheckIfHasOpenTicket(String username, int id) {
        boolean duplicate = false;
        try {
            MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OpenTickets");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (list.get(id).equals(username)) {
                    duplicate = true;
                    break;
                }
            }
        } catch (Exception e) {System.out.println(e);}
        return duplicate;
    }

    //Creates a ticket, storing basic information into database.
    public void CreateTicket(String username, String issueInfo)
    {
        MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OpenTickets");
        Document ticket = new Document
                ("CustomerUsername", username).append
                ("CustomerIssue", issueInfo);
        col.insertOne(ticket);
    }

    //Allows technician to select a ticket to do
    public void TechnicianSelectTicket(String username, String userIssue, String techUsername)
    {
        MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OngoingTickets");
        Document ticket = new Document
                ("CustomerUsername", username).append
                ("TechnicianUsername", techUsername).append
                ("UserIssue", userIssue);
        col.insertOne(ticket);
        RemoveOpenTicket(username);
    }

    //removes an open ticket from the database.
    public void RemoveOpenTicket(String username)
    {
        try
        {
            MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OpenTickets");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(1))) {
                    col.deleteOne(Filters.eq("CustomerUsername", username));
                    break;
                }
            }
        }
        catch (Exception e)
        {System.out.println(e);}
    }
    //closes ticket and sends information to closed tickets.
    public void TechnicianCloseTicket(String technicianUsername, String customerUsername, String userIssue, String note)
    {
        MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("Tickets");
        Document ticket = new Document
                ("CustomerUsername", customerUsername).append
                ("TechnicianUsername", technicianUsername).append
                ("UserIssue", userIssue).append
                ("Note", note);
        col.insertOne(ticket);
        RemoveOngoingTicket(customerUsername);
    }
    //removes ongoing ticket from database.
    public void RemoveOngoingTicket(String username)
    {
        try
        {
            MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("OngoingTickets");
            for (Document doc : col.find()) {
                List list = new ArrayList(doc.values());
                if (username.equals(list.get(1))) {
                    col.deleteOne(Filters.eq("CustomerUsername", username));
                    break;
                }
            }
        }
        catch (Exception e)
        {System.out.println(e);}
    }

    public void UserChat(String technicianUser, String customerUser, String chatText)
    {
        MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("UserChat");

        Document chatDetail = new Document
                ("Technician", technicianUser).append
                ("Customer", customerUser).append
                ("ChatSentBy", Menu.getUsername()).append
                ("Chat", chatText);
        col.insertOne(chatDetail);

    }
    public void loadChat(ListView lstChat, String technicianUser, String customerUser) {
        MongoCollection<Document> col = getUsers().getDatabase().GetDatabase().getCollection("UserChat");
        lstChat.getItems().clear();

        for (Document doc : col.find()) {
            List list = new ArrayList(doc.values());
            if (technicianUser.equals(Menu.getUsername()) || customerUser.equals(Menu.getUsername())) {
                lstChat.getItems().add(list.get(3) +": " + list.get(4));
            }
        }
    }
}
