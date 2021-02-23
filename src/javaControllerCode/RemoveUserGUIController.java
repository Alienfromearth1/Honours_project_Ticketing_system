package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveUserGUIController implements Initializable {
    Menu menu = new Menu();

    // ============================== VARIABLES ==============================
    @FXML private Button btnMenu;
    @FXML private Button btnRemoveUser;
    @FXML private ListView lstUsers;
    @FXML private Button load;

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        menu.getTickets().getUsers().getDatabase().RemoveUsers(lstUsers.getSelectionModel().getSelectedItem().toString());
    }

    // ============================== CONSTRUCTOR ==============================
    public RemoveUserGUIController(){}

    // ============================== BUTTON CONTROL ==============================
    public void ReturnToMenu(ActionEvent event) throws Exception
    {
        menu.ReturnToMenu(btnMenu, menu.getGuiType());
    }

    public void loadUsers(ActionEvent actionEvent) {
        menu.getTickets().getUsers().getDatabase().LoadUsers(lstUsers);
    }
}
