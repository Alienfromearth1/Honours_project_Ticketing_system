package javaControllerCode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginGUIController {
    // ============================== LOGIN VARIABLES ==============================
    @FXML private Button btnLogin;
    @FXML private PasswordField pTxtPassword;
    @FXML private TextField txtUsername;

    // ============================== CONSTRUCTOR ==============================
    public LoginGUIController(){}

    // ============================== LOGIN CONTROLS ==============================
    @FXML
    public void AttemptLogin() throws Exception
    {
        Stage stage;
        Parent root;

        stage = (Stage) btnLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../fxmlCode/AdminMainMenuGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML //Closes the system.
    public void CloseApplication() {System.exit(0);}
}
