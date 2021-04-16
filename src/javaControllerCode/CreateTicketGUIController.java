package javaControllerCode;

import javaCode.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateTicketGUIController extends Component implements Initializable {



    // ============================== VARIABLES ==============================
    byte[] data = null;
    String fileName = null;
    Menu menu = new Menu();
    @FXML private Button btnMenu;
    @FXML private TextArea txtUserProblem;
    @FXML private Label lblImageSource;

    //Initialise
    @Override public void initialize(URL location, ResourceBundle resources) {}

    // ============================== CONSTRUCTOR ==============================
    public CreateTicketGUIController(){}

    // ============================== BUTTON CONTROLLER ==============================
    public void ReturnToMenu() throws Exception
    {
        menu.ReturnToMenu(btnMenu, Menu.getGuiType());
    }

    @FXML
    public void CreateNewTicket()
    {
        try {
            menu.getTickets().CreateTicket(Menu.getUsername(), txtUserProblem.getText());
            if (data != null) {SaveImage(data);}
            JOptionPane.showMessageDialog(null, "Ticket successfully created");
            }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Couldn't create ticket\nIf problem persists please contact administrator");
        }
        btnMenu.fire();
    }

    @FXML
    public void UploadImage() throws IOException
    {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            fileName = file.getAbsolutePath();
            lblImageSource.setText(file.toString());
            BufferedImage bufferedImage = ImageIO.read(new File(fileName));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", bos);
            data = bos.toByteArray();
    }

    public void SaveImage(byte[] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "png", new File(Menu.getUsername() + ".png") );
    }
}
