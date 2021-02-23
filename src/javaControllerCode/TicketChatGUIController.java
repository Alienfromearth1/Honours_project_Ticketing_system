package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // ============================== CONSTRUCTOR ==============================
    public TicketChatGUIController(){}

    // ============================== BUTTON CONTROL ==============================
    @FXML
    public void ReturnToMenu(ActionEvent event) throws Exception
    {
    menu.ReturnToMenu(btnMenu, menu.getGuiType());
    }
}
