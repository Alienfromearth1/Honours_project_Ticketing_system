package javaControllerCode;

import javaCode.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserGUIController implements Initializable {

    //Initialise
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // ============================== VARIABLES ==============================
    Menu menu = new Menu();
    @FXML private Button btnMenu;
    @FXML private TextField txtFname;
    @FXML private TextField txtSname;
    @FXML private TextField txtUserName;
    @FXML private PasswordField txtPassword;
    @FXML private PasswordField txtConfirmPass;
    @FXML private CheckBox chkTechnician;
    // ============================== CONSTRUCTOR ==============================
    public CreateUserGUIController(){}

    // ============================== BUTTON CONTROL ==============================
    public void ReturnToMenu(ActionEvent event) throws Exception
    {
        menu.ReturnToMenu(btnMenu, menu.getGuiType());
    }

    public void CreateUser(ActionEvent actionEvent) throws Exception
    {
        if (txtConfirmPass.getText().equals(txtPassword.getText()))
        {
            menu.getTickets().getUsers().CreateUser(txtFname.getText(), txtSname.getText(), txtUserName.getText(), txtPassword.getText(), txtConfirmPass.getText(), chkTechnician.isSelected(), btnMenu);
        }
    }
}
