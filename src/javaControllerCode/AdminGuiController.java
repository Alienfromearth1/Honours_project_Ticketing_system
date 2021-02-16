package javaControllerCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminGuiController {

    // ============================== VARIABLES ==============================
    @FXML private Button btnAdminAddUser;
    @FXML private Button btnAdminRemoveUser;
    @FXML private Button btnAdminViewPreviousTicket;
    @FXML private Button btnAdminLogOut;

    // ============================== CONSTRUCTOR ==============================
    public AdminGuiController(){}

    // ============================== BUTTON CONTROL ==============================
    public void AdminMainMenuOptions(ActionEvent event) throws Exception
    {
        Stage stage;
        Parent root;

        if(event.getSource()==btnAdminAddUser){
            stage = (Stage) btnAdminAddUser.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/CreateNewUserGUI.fxml"));
        }
        else if(event.getSource()==btnAdminRemoveUser)
        {
            stage = (Stage) btnAdminRemoveUser.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/RemoveUserGUI.fxml"));
        }
        else if(event.getSource()==btnAdminLogOut)
        {
            stage = (Stage) btnAdminLogOut.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/LoginGUI.fxml"));
        }
        else
        {
            stage = (Stage) btnAdminViewPreviousTicket.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/ViewPreviousTicketGUI.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
