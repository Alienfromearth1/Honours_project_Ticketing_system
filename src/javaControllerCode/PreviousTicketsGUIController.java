package javaControllerCode;

import javaCode.Menu;
import javaCode.Tickets;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class PreviousTicketsGUIController implements Initializable {

private Tickets tickets = new Tickets();
Menu menu = new Menu();
    @FXML private Button btnLoad;
    @FXML private ListView lstPreviousTicket;
    @FXML private Button btnMenu;

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    tickets.LoadPreviousTickets(lstPreviousTicket);
    }

    // ============================== CONSTRUCTOR ==============================
    public PreviousTicketsGUIController(){}

    // ============================== BUTTON CONTROL ==============================
    public void ReturnToMenu() throws Exception {
        menu.ReturnToMenu(btnMenu, menu.getGuiType());
    }
}