//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package javaControllerCode;

import javaCode.Menu;
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
    Menu menu = new Menu();
    private String userImage;
    @FXML
    private Button btnMenu;
    @FXML
    private TextField txtChat;
    @FXML
    private ListView lstChat;
    @FXML
    private Label lblInformation;
    @FXML
    private Label lblCustomer;
    @FXML
    private Label lblTechnician;
    @FXML
    private ImageView imgUserImage;

    public void initialize(URL location, ResourceBundle resources) {

        menu.getTickets().getOngoingTicketInfo(Menu.getUsername(), lblInformation, lblCustomer, lblTechnician);

        String[] splitCustomer = lblCustomer.getText().split(" ", 3);
        String[] splitTechnician = lblTechnician.getText().split(" ", 3);


        try {DisplayImage();}
        catch (Exception e) {System.out.println(e);}

        try {menu.getTickets().loadChat(lstChat, splitTechnician[1], splitCustomer[1]);}
        catch (Exception e) {lstChat.getItems().add("Problem getting chat information, try again later");}


    }

    public TicketChatGUIController() {
    }

    @FXML
    public void ReturnToMenu() throws Exception {
        this.menu.ReturnToMenu(btnMenu, Menu.getGuiType());
    }

    public void CloseTicket() {
        String[] splitCustomer = lblCustomer.getText().split(" ", 3);
        String[] splitTechnician = lblTechnician.getText().split(" ", 3);
        String note = JOptionPane.showInputDialog("Enter finishing note");
        menu.getTickets().TechnicianCloseTicket(splitTechnician[1], splitCustomer[1], lblInformation.getText(), note);
        menu.getTickets().TechnicianCloseTicket(splitTechnician[1], splitCustomer[1], lblInformation.getText(), note);
        (new File(userImage + ".png")).delete();
        btnMenu.fire();
    }

    public void DisplayImage() {
        Image image = new Image((new File(userImage + ".png")).toURI().toString());
        imgUserImage.setImage(image);
    }

    public void SendMessage() {
        String[] splitCustomer = lblCustomer.getText().split(" ", 3);
        String[] splitTechnician = lblTechnician.getText().split(" ", 3);
        menu.getTickets().UserChat(splitTechnician[1], splitCustomer[1], txtChat.getText());
        txtChat.clear();
        txtChat.requestFocus();
        menu.getTickets().loadChat(lstChat, splitTechnician[1], splitCustomer[1]);
    }
}
