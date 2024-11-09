package riveree;


// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.stage.Stage;

// import java.io.IOException;

// public class Logincontroller {

//     @FXML
//     private TextField tfUsername;

//     @FXML
//     private PasswordField tfPw;
//      @FXML
//     private void handleSignUpButton(ActionEvent event) {
//         try {
//             FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
//             Parent root = loader.load();

//             Stage stage = (Stage) tfUsername.getScene().getWindow();
//             stage.setScene(new Scene(root));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     @FXML
//     private void loginButtonAction(ActionEvent event) {
//         String username = tfUsername.getText();
//         String password = tfPw.getText();

//         // Perform login authentication logic here
//         boolean isLoginValid = authenticate(username, password);

//         if (isLoginValid) {
//             // Transition to the homepage
//             try {
//                 FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage111.fxml"));
//                 Parent root = loader.load();

//                 Stage stage = (Stage) tfUsername.getScene().getWindow();
//                 stage.setScene(new Scene(root));
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         } else {
//             // Handle invalid login credentials
//             System.out.println("Invalid login credentials");
//         }
//     }

//     private boolean authenticate(String username, String password) {
//         // Implement your authentication logic here
//         // You can check the username and password against a database or any other authentication mechanism
//         // For simplicity, this example considers the login valid if the username and password are not empty
//         return !username.isEmpty() && !password.isEmpty();
//     }
// }






// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.stage.Stage;
// import org.w3c.dom.Document;
// import org.w3c.dom.Element;
// import org.w3c.dom.NodeList;

// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import java.io.File;
// import java.io.IOException;

// public class Logincontroller {

//     @FXML
//     private TextField tfEmail;
//     @FXML
//     private PasswordField pfPassword;
//     @FXML
//     private Button loginButton;
//     @FXML
//     private Button signUpButton;

//     @FXML
  
//     private void handleSignUpButton(ActionEvent event) {
//         try {
//             FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp"));
//             Parent root = loader.load();

//             Stage stage = (Stage) signUpButton.getScene().getWindow();
//             stage.setScene(new Scene(root));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     @FXML
//     public void login(ActionEvent event) {
//         String email = tfEmail.getText();
//         String password = pfPassword.getText();

//         if (isValidLoginCredentials(email, password)) {
//             try {
//                 Parent root = FXMLLoader.load(getClass().getResource("homepage111.fxml"));
//                 Stage stage = (Stage) loginButton.getScene().getWindow();
//                 stage.setScene(new Scene(root));
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         } else {
//             showLoginErrorAlert();
//         }
//     }

//     private boolean isValidLoginCredentials(String email, String password) {
//         if (email.isEmpty() || password.isEmpty()) {
//             return false; // Return false if either email or password is empty
//         }

//         try {
//             File xmlFile = new File("src/riveree/Model/Users.xml");
//             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//             Document doc = dBuilder.parse(xmlFile);

//             doc.getDocumentElement().normalize();
//             NodeList nodeList = doc.getElementsByTagName("user");

//             for (int i = 0; i < nodeList.getLength(); i++) {
//                 Element userElement = (Element) nodeList.item(i);
//                 String storedEmail = userElement.getElementsByTagName("email").item(0).getTextContent();
//                 String storedPassword = userElement.getElementsByTagName("password").item(0).getTextContent();

//                 if (email.equals(storedEmail) && password.equals(storedPassword)) {
//                     return true; // Return true if email and password match a user in the XML
//                 }
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         return false; // Return false if no matching user is found or an error occurs
//     }

//     private void showLoginErrorAlert() {
//         Alert alert = new Alert(Alert.AlertType.ERROR);
//         alert.setTitle("Login Error");
//         alert.setHeaderText(null);
//         alert.setContentText("Invalid email or password. Please try again.");
//         alert.showAndWait();
//     }
// }





















import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class Logincontroller {

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private void handleSignUpButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) signUpButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }

    @FXML
    public void login(ActionEvent event) {
        String email = tfEmail.getText();
        String password = pfPassword.getText();

        if (isValidLoginCredentials(email, password)) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("homepage111.fxml"));
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showLoginErrorAlert();
        }
    }

    private boolean isValidLoginCredentials(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return false; // Return false if either email or password is empty
        }

        try {
            File xmlFile = new File("src/riveree/Model/Users.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element userElement = (Element) nodeList.item(i);
                String storedEmail = userElement.getElementsByTagName("email").item(0).getTextContent();
                String storedPassword = userElement.getElementsByTagName("password").item(0).getTextContent();

                if (email.equals(storedEmail) && password.equals(storedPassword)) {
                    return true; // Return true if email and password match a user in the XML
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // Return false if no matching user is found or an error occurs
    }

    private void showLoginErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText("\u0646\u0633\u064A\u062A \u064A\u0627\u0642\u062D\u0628\u0647");
        alert.showAndWait();
    }
}
// Invalid email or password. Please try again.
 