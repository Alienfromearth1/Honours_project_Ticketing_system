package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TechnicianGUIController implements Initializable {

    // ============================== VARIABLES ==============================
    @FXML private Button btnTechnicianViewOpenTickets;
    @FXML private Button btnTechnicianViewOngoingTicket;
    @FXML private Button btnTechnicianViewPreviousTicket;
    @FXML private Button btnTechnicianLogOut;
    private Menu menu = new Menu();

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    if (menu.getTickets().getUsers().getDatabase().CheckIfHasTicket(menu.getUsername(), 2)) {
      btnTechnicianViewOpenTickets.setVisible(false);
    }

    }

    // ============================== CONSTRUCTOR ==============================
    public TechnicianGUIController(){}

    // ============================== BUTTON CONTROL ==============================

    public void TechnicianMainMenuOptions(ActionEvent event) throws IOException {
       menu.TechnicianMainMenuOptions(event, btnTechnicianLogOut, btnTechnicianViewOngoingTicket, btnTechnicianViewOpenTickets, btnTechnicianViewPreviousTicket);
    }
}
