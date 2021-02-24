package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class OpenTicketsGUIController implements Initializable {

    // ============================== VARIABLES ==============================
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnSelectTicket;
    @FXML
    private ListView lstOpenTickets;
    private String username, guiType;
    private Menu menu = new Menu();

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menu.getTickets().getUsers().getDatabase().LoadOpenTickets(lstOpenTickets);
    }

    // ============================== CONSTRUCTOR ==============================
    public OpenTicketsGUIController() {
    }

    // ============================== BUTTON CONTROLLER ==============================
    public void ReturnToMenu() throws Exception {
        menu.ReturnToMenu(btnMenu, menu.getGuiType());
    }


    public void SelectTicket(ActionEvent event) {
        String temp = lstOpenTickets.getSelectionModel().getSelectedItem().toString();
        System.out.println(temp);
        String[] split = temp.split(" ", 4);
        menu.getTickets().getUsers().getDatabase().TechnicianSelectTicket(split[1], split[3], menu.getUsername());

    }
}