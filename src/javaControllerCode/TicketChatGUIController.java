package javaControllerCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TicketChatGUIController {

    // ============================== VARIABLES ==============================
    @FXML private Button btnMenu;
    @FXML private Button btnCloseTicket;
    @FXML private TextField txtChat;
    @FXML private ListView lstChat;
    @FXML private Label lblInformation;

    // ============================== CONSTRUCTOR ==============================
    public TicketChatGUIController(){}

    // ============================== BUTTON CONTROL ==============================
    @FXML
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
}
