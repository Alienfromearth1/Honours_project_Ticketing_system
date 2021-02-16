package javaControllerCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TechnicianGUIController {

    // ============================== VARIABLES ==============================
    @FXML private Button btnTechnicianViewOpenTickets;
    @FXML private Button btnTechnicianViewOngoingTicket;
    @FXML private Button btnTechnicianViewPreviousTicket;
    @FXML private Button btnTechnicianLogOut;

    // ============================== CONSTRUCTOR ==============================
    public TechnicianGUIController(){}

    // ============================== BUTTON CONTROL ==============================
    public void TechnicianMainMenuOptions(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if(event.getSource()==btnTechnicianViewOpenTickets){
            stage = (Stage) btnTechnicianViewOpenTickets.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/OpenTicketsListGUI.fxml"));
        }
        else if(event.getSource()==btnTechnicianLogOut)
        {
            stage = (Stage) btnTechnicianLogOut.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/LoginGUI.fxml"));
        }
        else if(event.getSource()==btnTechnicianViewOngoingTicket)
        {
            stage = (Stage) btnTechnicianViewOngoingTicket.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/OpenTicketChatGUI.fxml"));
        }
        else
        {
            stage = (Stage) btnTechnicianViewPreviousTicket.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/ViewPreviousTicketGUI.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
