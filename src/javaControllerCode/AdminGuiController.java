package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminGuiController implements Initializable {

    // ============================== VARIABLES ==============================
    @FXML private Button btnAdminAddUser;
    @FXML private Button btnAdminRemoveUser;
    @FXML private Button btnAdminViewPreviousTicket;
    @FXML private Button btnAdminLogOut;
    Menu menu = new Menu();

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    // ============================== CONSTRUCTOR ==============================
    public AdminGuiController(){}

    // ============================== BUTTON CONTROL ==============================
    public void AdminMainMenuOptions(ActionEvent event) throws Exception
    {
        menu.AdminMainMenuOptions(event, btnAdminAddUser, btnAdminLogOut, btnAdminRemoveUser, btnAdminViewPreviousTicket);
    }
}
