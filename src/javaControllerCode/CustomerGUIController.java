package javaControllerCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerGUIController {

    // ============================== VARIABLES ==============================
    @FXML private Button btnCustomerTicketCreate;
    @FXML private Button btnViewOngoingTicket;
    @FXML private Button btnViewPreviousTicket;
    @FXML private Button btnCustomerLogOut;

    // ============================== CONSTRUCTOR ==============================
    public CustomerGUIController(){}

    // ============================== BUTTON CONTROLS ==============================
        @FXML
        private void CustomerMainMenuOptions(ActionEvent event) throws Exception {
            Stage stage;
            Parent root;

            if(event.getSource()==btnCustomerTicketCreate)
            {
                stage = (Stage) btnCustomerTicketCreate.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxmlCode/CreateNewTicketGUI.fxml"));
            }
            else if(event.getSource()==btnCustomerLogOut)
            {
                stage = (Stage) btnCustomerLogOut.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxmlCode/LoginGUI.fxml"));
            }
            else if(event.getSource()==btnViewOngoingTicket)
            {
                stage = (Stage) btnViewOngoingTicket.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxmlCode/OpenTicketChatGUI.fxml"));
            }
            else
            {
                stage = (Stage) btnViewPreviousTicket.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("../fxmlCode/ViewPreviousTicketGUI.fxml"));
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
}
