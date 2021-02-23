package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerGUIController implements Initializable {

    // ============================== VARIABLES ==============================
    @FXML private Button btnCustomerTicketCreate;
    @FXML private Button btnViewOngoingTicket;
    @FXML private Button btnViewPreviousTicket;
    @FXML private Button btnCustomerLogOut;
    private Menu menu = new Menu();


    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // ============================== CONSTRUCTOR ==============================
    public CustomerGUIController(){}

    // ============================== BUTTON CONTROLS ==============================
        @FXML
        private void CustomerMainMenuOptions(ActionEvent event) throws Exception
        {
            menu.CustomerMainMenuOptions(event, btnCustomerTicketCreate, btnCustomerLogOut, btnViewOngoingTicket, btnViewPreviousTicket);
        }
}
