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

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TicketChatGUIController implements Initializable {



    // ============================== VARIABLES ==============================

    Menu menu = new Menu();
    private String userImage;
    @FXML private Button btnMenu;
    @FXML private Button btnCloseTicket;
    @FXML private TextField txtChat;
    @FXML private ListView lstChat;
    @FXML private Label lblInformation;
    @FXML private Label lblCustomer;
    @FXML private Label lblTechnician;
    @FXML private ImageView imgUserImage;
    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        userImage = menu.getTickets().getUsers().getDatabase().getOngoingTicketInfo(menu.getUsername(), lblInformation, lblCustomer, lblTechnician);
        try
        {
            DisplayImage();
        }
        catch (Exception e) {}
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
        String note = JOptionPane.showInputDialog("Enter finishing note");
        menu.getTickets().getUsers().getDatabase().TechnicianCloseTicket(splitTechnician[1], splitCustomer[1], lblInformation.getText(), note);
        btnMenu.fire();
        new File(userImage + ".png").delete();
    }

    public void DisplayImage()
    {
            Image image = new Image(new File( userImage + ".png").toURI().toString());
            imgUserImage.setImage(image);
    }
}
