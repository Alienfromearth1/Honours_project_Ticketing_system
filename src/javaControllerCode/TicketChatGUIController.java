package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TicketChatGUIController implements Initializable {



    // ============================== VARIABLES ==============================
    Menu menu = new Menu();
    @FXML private Button btnMenu;
    @FXML private Button btnCloseTicket;
    @FXML private TextField txtChat;
    @FXML private ListView lstChat;
    @FXML private Label lblInformation;
    @FXML private Label lblCustomer;
    @FXML private Label lblTechnician;
    @FXML private ImageView imgUserImage;
    String[] split;
    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        menu.getTickets().getUsers().getDatabase().getOngoingTicketInfo(menu.getUsername(), lblInformation, lblCustomer, lblTechnician);

        String temp = lblInformation.getText();
        split = temp.split(" ", 4);

        DisplayImage(split[2]);

    }

    // ============================== CONSTRUCTOR ==============================
    public TicketChatGUIController(){}

    // ============================== BUTTON CONTROL ==============================
    @FXML
    public void ReturnToMenu(ActionEvent event) throws Exception
    {
    menu.ReturnToMenu(btnMenu, menu.getGuiType());
    }


    public void CloseTicket(ActionEvent event)
    {

        String[] splitCustomer = lblCustomer.getText().toString().split(" ", 3);
        String[] splitTechnician = lblTechnician.getText().toString().split(" ", 3);


       menu.getTickets().getUsers().getDatabase().TechnicianCloseTicket(splitTechnician[1], splitCustomer[1], lblInformation.getText());
    }


    public void DisplayImage(String username)
    {
        Image image = new Image(new File(menu.getUsername() + ".png").toURI().toString());
        imgUserImage.setImage(image);
    }
}
