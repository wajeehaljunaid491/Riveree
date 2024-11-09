package riveree;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RiverGuardController {

    @FXML
    private Button contactButton;
    
    @FXML
    private Button instagramButton;

    @FXML
    private Button facebookButton;

    @FXML
    private void initialize() {
        // Initialize the controller
        // Add event handlers or any necessary initialization code here
       
        contactButton.setOnAction(event -> openWhatsAppChat());
        instagramButton.setOnAction(event -> openInstagram());
        facebookButton.setOnAction(event -> openFacebook());
    }

    private void openWhatsAppChat() {
        try {
            Desktop.getDesktop().browse(new URI("https://wa.me/+6281218383195"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void openInstagram() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.instagram.com/noth.inc.uii/"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void openFacebook() {
        try {
            Desktop.getDesktop().browse(new URI("https://www.facebook.com"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
