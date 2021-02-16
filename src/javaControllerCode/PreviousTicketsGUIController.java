package javaControllerCode;

import javaCode.Tickets;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class PreviousTicketsGUIController {

private Tickets tickets = new Tickets();
    @FXML private Button btnLoad;
    @FXML private ListView lstPreviousTicket;
    @FXML private Button btnMenu;


    // ============================== CONSTRUCTOR ==============================
    public PreviousTicketsGUIController(){}



    // ============================== BUTTON CONTROL ==============================
    public void ReturnToMenu() throws Exception {
        Stage stage;
        Parent root;

        stage = (Stage) btnMenu.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../fxmlCode/AdminMainMenuGUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Refresh()
    {

tickets.getUsers().getDatabase().LoadPreviousTickets(lstPreviousTicket);


        //PQ8L56AIqd0CR1mL
        btnLoad.setVisible(false);



    }
}