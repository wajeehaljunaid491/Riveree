package riveree.lab;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;

public class labController implements Initializable {

    private TableViewSelectionModel<River> selectionModel;
    private River selectedRiver;
    private RiverList data;
    private RiverTableController riverTableController;

    @FXML
    private TextField nameField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField phField;
    @FXML
    private TextField temperatureField;
    @FXML
    private TextField ammoniaField;
    @FXML
    private TextField solidField;
    @FXML
    private TextField observerField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField dissolvesField;
    @FXML
    private TextField chemicalField;
    @FXML
    private TextField biologicalField;
    @FXML
    private TextField conclusionField;
    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = RiverDataXML.loadData();
        riverTableController = new RiverTableController();

        saveButton.setOnAction(event -> handleSaveButtonAction(event));
    }

    

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        String name = nameField.getText();
        String location = locationField.getText();
        double ph = Double.parseDouble(phField.getText());
        double temperature = Double.parseDouble(temperatureField.getText());
        double ammonia = Double.parseDouble(ammoniaField.getText());
        double solid = Double.parseDouble(solidField.getText());
        String observer = observerField.getText();
        String date = dateField.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE);
        
        double dissolvesOxygen = Double.parseDouble(dissolvesField.getText());
        double chemicalOxygen = Double.parseDouble(chemicalField.getText());
        double biologicalOxygen = Double.parseDouble(biologicalField.getText());
        String conclusion = conclusionField.getText();

        // Create a new River object with the entered data
        River newRiver = new River(name, location, ph, temperature, ammonia, solid,
                observer, date, dissolvesOxygen, chemicalOxygen, biologicalOxygen, conclusion);

        // Retrieve existing data from the XML database
        RiverList data = RiverDataXML.loadData();

        // Add the new River object to the existing data
        data.getData().add(newRiver);

        // Save the updated data to the XML file
        RiverDataXML.saveData(data);

        // Update the data in the RiverTableController
        // riverTableController.updateRiverData(newRiver);

        // Clear the input fields
        // clearFields();
        System.out.println("don");
    }

    // private void clearFields() {
    //     nameField.clear();
    //     locationField.clear();
    //     phField.clear();
    //     temperatureField.clear();
    //     ammoniaField.clear();
    //     solidField.clear();
    //     observerField.clear();
    //     dateField.getEditor().clear();
    //     dissolvesField.clear();
    //     chemicalField.clear();
    //     biologicalField.clear();
    //     conclusionField.clear();
    // }
}
