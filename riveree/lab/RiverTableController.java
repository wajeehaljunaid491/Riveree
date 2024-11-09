package riveree.lab;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;




public class RiverTableController implements Initializable {

    private TableView.TableViewSelectionModel<River> selectionModel;
    private River selectedRiver;
    private RiverList data;

    @FXML
    private TableView<River> tvRiver;
    @FXML
    private TableColumn<River, String> nameColumn;
    @FXML
    private TableColumn<River, String> locationColumn;
    @FXML
    private TableColumn<River, Double> pHColumn;
    @FXML
    private TableColumn<River, Double> temperatureColumn;
    @FXML
    private TableColumn<River, Double> ammoniaColumn;
    @FXML
    private TableColumn<River, Double> solidColumn;
    @FXML
    private TableColumn<River, String> observerColumn;
    @FXML
    private TableColumn<River, String> dateColumn;
    @FXML
    private TableColumn<River, Double> dissolvesColumn;
    @FXML
    private TableColumn<River, Double> chemicalColumn;
    @FXML
    private TableColumn<River, Double> biologicalColumn;
    @FXML
    private TableColumn<River, String> conclusionColumn;
    @FXML
    private Button deleteButton;

    @FXML
    private Button editeButton;
    

    private FilteredList<River> filteredData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data = RiverDataXML.loadData();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        pHColumn.setCellValueFactory(new PropertyValueFactory<>("pH"));
        pHColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        temperatureColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        temperatureColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        ammoniaColumn.setCellValueFactory(new PropertyValueFactory<>("ammonia"));
        ammoniaColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        solidColumn.setCellValueFactory(new PropertyValueFactory<>("solid"));
        solidColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        observerColumn.setCellValueFactory(new PropertyValueFactory<>("observer"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dissolvesColumn.setCellValueFactory(new PropertyValueFactory<>("dissolvesOxygen"));
        dissolvesColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        chemicalColumn.setCellValueFactory(new PropertyValueFactory<>("chemicalOxygen"));
        chemicalColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        biologicalColumn.setCellValueFactory(new PropertyValueFactory<>("biologicalOxygen"));
        biologicalColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        conclusionColumn.setCellValueFactory(new PropertyValueFactory<>("conclusion"));
        tvRiver.setItems(data.getData());
        tvRiver.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        selectionModel = tvRiver.getSelectionModel();

        filteredData = new FilteredList<>(data.getData());

        SortedList<River> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvRiver.comparatorProperty());
        tvRiver.setItems(sortedData);
    }

    @FXML
    private void delete(ActionEvent event) {
        River selectedRiver = selectionModel.getSelectedItem();
        if (selectedRiver != null) {
            data.getData().remove(selectedRiver);
            RiverDataXML.saveData(data);

            // Add your UI updates or show confirmation/alert messages here
        } else {
            // Handle case when no river is selected
        }
    }

    @FXML
    private void handleEditButtonAction(ActionEvent event) {
        selectedRiver = selectionModel.getSelectedItem();

        if (selectedRiver != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("edit_Window.fxml"));
                Parent root = loader.load();
                EditWindowController editController = loader.getController();
                editController.setRiver(selectedRiver);
                editController.setRiverlistData(data); // Pass the RiverList object

                Stage editStage = new Stage();
                editStage.setTitle("Edit River Data");
                editStage.setScene(new Scene(root));
                editStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
