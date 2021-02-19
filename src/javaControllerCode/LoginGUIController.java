package javaControllerCode;

import javaCode.Tickets;
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
    Tickets ticket = new Tickets();
    @FXML private Button btnLogin;
    @FXML private PasswordField pTxtPassword;
    @FXML private TextField txtUsername;

    // ============================== CONSTRUCTOR ==============================
    public LoginGUIController(){}

    // ============================== LOGIN CONTROLS ==============================
    @FXML
    public void AttemptLogin() throws Exception
    {
        try {
            final boolean technician = ticket.getUsers().getDatabase().userTypeCheck(txtUsername.getText(), 5);
            final boolean admin = ticket.getUsers().getDatabase().userTypeCheck(txtUsername.getText(), 6);
            String guiType = ticket.getUsers().LoginToSystem(txtUsername.getText(), pTxtPassword.getText(), technician, admin);

            Stage stage;
            Parent root;
            stage = (Stage) btnLogin.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(guiType));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    @FXML //Closes the system.
    public void CloseApplication() {System.exit(0);}
}
