package javaControllerCode;

import javaCode.Tickets;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RemoveUserGUIController {
Tickets tickets = new Tickets();

    // ============================== VARIABLES ==============================
    @FXML private Button btnMenu;
    @FXML private Button btnRemoveUser;
    @FXML private ListView lstUsers;
    @FXML private Button load;

    // ============================== CONSTRUCTOR ==============================
    public RemoveUserGUIController(){}

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

    public void loadUsers(ActionEvent actionEvent) {
        tickets.getUsers().getDatabase().LoadUsers(lstUsers);
    }

    public void RemoveUser(ActionEvent actionEvent) {
        System.out.println(lstUsers.getSelectionModel().getSelectedItem().toString());

        tickets.getUsers().getDatabase().RemoveUsers(lstUsers.getSelectionModel().getSelectedItem().toString());
    }
}
