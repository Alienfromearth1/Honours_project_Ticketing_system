package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class OpenTicketsGUIController implements Initializable {

    // ============================== VARIABLES ==============================
    @FXML private Button btnMenu;
    @FXML private Button btnSelectTicket;
    @FXML private ListView lstOpenTickets;
    private Menu menu = new Menu();

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menu.getTickets().LoadOpenTickets(lstOpenTickets);
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
        String[] split = temp.split(" ", 4);
        menu.getTickets().TechnicianSelectTicket(split[1], split[3], menu.getUsername());
        JOptionPane.showMessageDialog(null, "Ticket successfully selected");
        btnMenu.fire();
    }
}