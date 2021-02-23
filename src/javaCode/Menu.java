package javaCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    private static String username, guiType;
    Tickets tickets = new Tickets();

    public Menu() {
    }

    public Tickets getTickets() {
        return tickets;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Menu.username = username;
    }

    public static String getGuiType() {
        return guiType;
    }

    public static void setGuiType(String guiType) {
        Menu.guiType = guiType;
    }


    public void AttemptLogin(String username, String password, Button btnLogin) throws Exception {
        try
        {
            System.out.println(username);
            System.out.println(password);
            final boolean technician = tickets.getUsers().getDatabase().userTypeCheck(username, 6);
            final boolean admin = tickets.getUsers().getDatabase().userTypeCheck(username, 7);
            String guiType = tickets.getUsers().LoginToSystem(username, password, technician, admin);
            setUsername(username);
            setGuiType(guiType);
            Stage stage;
            Parent root;
            stage = (Stage) btnLogin.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(guiType));
            Run(root, stage);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void TechnicianMainMenuOptions(ActionEvent event, Button btnTechnicianLogOut, Button btnTechnicianViewOngoingTicket, Button btnTechnicianViewOpenTickets, Button btnTechnicianViewPreviousTicket) throws IOException {
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

        Run(root, stage);
    }

    public void AdminMainMenuOptions(ActionEvent event, Button btnAdminAddUser, Button btnAdminLogOut, Button btnAdminRemoveUser, Button btnAdminViewPreviousTicket) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == btnAdminAddUser) {
            stage = (Stage) btnAdminAddUser.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/CreateNewUserGUI.fxml"));
        } else if (event.getSource() == btnAdminRemoveUser) {
            stage = (Stage) btnAdminRemoveUser.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/RemoveUserGUI.fxml"));
        } else if (event.getSource() == btnAdminLogOut) {
            stage = (Stage) btnAdminLogOut.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/LoginGUI.fxml"));
        } else {
            stage = (Stage) btnAdminViewPreviousTicket.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/ViewPreviousTicketGUI.fxml"));
        }

        Run(root, stage);

    }

    public void CustomerMainMenuOptions(ActionEvent event, Button btnCustomerTicketCreate, Button btnCustomerLogOut, Button btnViewOngoingTicket, Button btnViewPreviousTicket) throws Exception {
        Stage stage;
        Parent root;

        if (event.getSource() == btnCustomerTicketCreate) {
            stage = (Stage) btnCustomerTicketCreate.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/CreateNewTicketGUI.fxml"));
        } else if (event.getSource() == btnCustomerLogOut) {
            stage = (Stage) btnCustomerLogOut.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/LoginGUI.fxml"));
        } else if (event.getSource() == btnViewOngoingTicket) {
            stage = (Stage) btnViewOngoingTicket.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/OpenTicketChatGUI.fxml"));
        } else {
            stage = (Stage) btnViewPreviousTicket.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../fxmlCode/ViewPreviousTicketGUI.fxml"));
        }
        Run(root, stage);
    }

    public void ReturnToMenu(Button btnMenu, String guiType) throws Exception {

        Stage stage;
        Parent root;
        stage = (Stage) btnMenu.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(guiType));

        Run(root, stage);
    }

        public void Run (Parent root, Stage stage)
        {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
