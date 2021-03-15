package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerGUIController implements Initializable {


    // ============================== VARIABLES ==============================
    @FXML private Button btnCustomerTicketCreate;
    @FXML private Button btnViewOngoingTicket;
    @FXML private Button btnViewPreviousTicket;
    @FXML private Button btnCustomerLogOut;
    @FXML private Label lblNotify;
    private Menu menu = new Menu();


    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {
CheckTickets();
    }

    // ============================== CONSTRUCTOR ==============================

    @FXML
    private void CheckTickets()
    {
        if (menu.getTickets().getUsers().getDatabase().CheckIfHasTicket(menu.getUsername(), 2)) {
            btnCustomerTicketCreate.setVisible(false);
            lblNotify.setText("Please go to ticket chat");
        }
        else if (menu.getTickets().getUsers().getDatabase().CheckIfHasOpenTicket(menu.getUsername(), 1))
        {
            btnViewOngoingTicket.setVisible(false);
            btnCustomerTicketCreate.setVisible(false);
            lblNotify.setText("Currently waiting for available technician");
        }
        else
        {
            btnViewOngoingTicket.setVisible(false);
        }
    }
    // ============================== BUTTON CONTROLS ==============================
    @FXML
        private void CustomerMainMenuOptions(ActionEvent event) throws Exception
        {
            menu.CustomerMainMenuOptions(event, btnCustomerTicketCreate, btnCustomerLogOut, btnViewOngoingTicket, btnViewPreviousTicket);
        }


}
