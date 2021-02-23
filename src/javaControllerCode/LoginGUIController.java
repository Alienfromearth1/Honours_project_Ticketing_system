package javaControllerCode;

import javaCode.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginGUIController implements Initializable {
    // ============================== LOGIN VARIABLES ==============================
    Menu menu = new Menu();
    @FXML private Button btnLogin;
    @FXML private PasswordField pTxtPassword;
    @FXML private TextField txtUsername;

    // ============================== CONSTRUCTOR ==============================
    public LoginGUIController(){}


    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    // ============================== LOGIN CONTROLS ==============================
    @FXML
    public void AttemptLogin() throws Exception
    {
menu.AttemptLogin(txtUsername.getText(), pTxtPassword.getText(), btnLogin);
    }


    @FXML //Closes the system.
    public void CloseApplication() {System.exit(0);}
}
