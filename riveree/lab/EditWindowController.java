package riveree.lab;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditWindowController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField pHField;
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

    private River selectedRiver;
    private RiverList data;

    public void setRiver(River river) {
        selectedRiver = river;

        nameField.setText(river.getName());
        locationField.setText(river.getLocation());
        pHField.setText(Double.toString(river.getpH()));
        temperatureField.setText(Double.toString(river.getTemperature()));
        ammoniaField.setText(Double.toString(river.getAmmonia()));
        solidField.setText(Double.toString(river.getSolid()));
        observerField.setText(river.getObserver());
        dateField.setValue(LocalDate.parse(river.getDate()));

        dissolvesField.setText(Double.toString(river.getDissolvesOxygen()));
        chemicalField.setText(Double.toString(river.getChemicalOxygen()));
        biologicalField.setText(Double.toString(river.getBiologicalOxygen()));
        conclusionField.setText(river.getConclusion());
    }

    public void setRiverlistData(RiverList riverlistData) {
        data = riverlistData;
    }

    @FXML
    private void handleSaveButtonAction() {
        if (selectedRiver != null) {
            selectedRiver.setName(nameField.getText());
            selectedRiver.setLocation(locationField.getText());
            selectedRiver.setpH(Double.parseDouble(pHField.getText()));
            selectedRiver.setTemperature(Double.parseDouble(temperatureField.getText()));
            selectedRiver.setAmmonia(Double.parseDouble(ammoniaField.getText()));
            selectedRiver.setSolid(Double.parseDouble(solidField.getText()));
            selectedRiver.setObserver(observerField.getText());
            selectedRiver.setDate(dateField.getValue().toString());

            selectedRiver.setDissolvesOxygen(Double.parseDouble(dissolvesField.getText()));
            selectedRiver.setChemicalOxygen(Double.parseDouble(chemicalField.getText()));
            selectedRiver.setBiologicalOxygen(Double.parseDouble(biologicalField.getText()));
            selectedRiver.setConclusion(conclusionField.getText());
            RiverDataXML.saveData(data); 

            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.close();
        }
    }
}
