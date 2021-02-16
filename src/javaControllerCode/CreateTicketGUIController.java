package javaControllerCode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CreateTicketGUIController {

    // ============================== VARIABLES ==============================
    @FXML private Button btnMenu;
    @FXML private Button btnCreateTicket;
    @FXML private Button btnUpload;
    @FXML private TextArea txtUserProblem;

    // ============================== CONSTRUCTOR ==============================
    public CreateTicketGUIController(){}

    // ============================== BUTTON CONTROLLER ==============================
    public void ReturnToMenu() throws Exception
    {
        Stage stage;
        Parent root;

        stage = (Stage) btnMenu.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../fxmlCode/AdminMainMenuGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
