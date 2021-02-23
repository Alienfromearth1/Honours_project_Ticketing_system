package javaControllerCode;

import javaCode.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateTicketGUIController implements Initializable {

    // ============================== VARIABLES ==============================
    Menu menu = new Menu();
    @FXML private Button btnMenu;
    @FXML private Button btnCreateTicket;
    @FXML private Button btnUpload;
    @FXML private TextArea txtUserProblem;

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // ============================== CONSTRUCTOR ==============================
    public CreateTicketGUIController(){}

    // ============================== BUTTON CONTROLLER ==============================
    public void ReturnToMenu() throws Exception
    {
menu.ReturnToMenu(btnMenu, menu.getGuiType());
    }

    @FXML
    public void CreateNewTicket()
    {
        menu.getTickets().getUsers().getDatabase().CreateTicket(menu.getUsername(), txtUserProblem.getText());

    }
}
