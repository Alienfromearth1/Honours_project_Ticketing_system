package javaControllerCode;

import javaCode.Tickets;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class CreateUserGUIController {


    // ============================== VARIABLES ==============================
    Tickets tickets = new Tickets();
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
        Stage stage;
        Parent root;

        stage = (Stage) btnMenu.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../fxmlCode/AdminMainMenuGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void CreateUser(ActionEvent actionEvent) throws Exception
    {
        if (txtConfirmPass.getText().equals(txtPassword.getText()))
        {
            tickets.getUsers().CreateUser(txtFname.getText(), txtSname.getText(), txtUserName.getText(), txtPassword.getText(), chkTechnician.isSelected());
            JOptionPane.showMessageDialog (null, "User successfully added", "User added", JOptionPane.INFORMATION_MESSAGE);
            ReturnToMenu(actionEvent);
        }

    }
}
