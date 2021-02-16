package javaControllerCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class OpenTicketsGUIController {

    // ============================== VARIABLES ==============================
    @FXML private Button btnMenu;
    @FXML private Button btnSelectTicket;
    @FXML private ListView lstOpenTickets;

    // ============================== CONSTRUCTOR ==============================
    public OpenTicketsGUIController(){}

    // ============================== BUTTON CONTROLLER ==============================
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