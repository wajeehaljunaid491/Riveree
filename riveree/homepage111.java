

package riveree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import riveree.lab.River;
import riveree.lab.RiverDataXML;
import riveree.lab.RiverList;

public class homepage111 implements Initializable {
    OpenScene openScene = new OpenScene();

    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart MybarChart;
    @FXML
    private TabPane tabPane;



    @FXML
    private BorderPane mainPane;

    

   

    @FXML
    private void homepage1(ActionEvent event) {
        System.out.println("Button Page 2 is clicked!");
        Pane page = openScene.getPane("lab/observation111");
        mainPane.setCenter(page);
    }

   

    @FXML
    private void DataLibrary(ActionEvent event) {
        System.out.println("Button Page 4 is clicked!");
        Pane page = openScene.getPane("lab/DataLibrary");
        mainPane.setCenter(page);
    }

    @FXML
    private void help(ActionEvent event) {
        System.out.println("Button Page 2 is clicked!");
        Pane page = openScene.getPane("riverguard");
        mainPane.setCenter(page);
    }

   

    @FXML
    private Button btnCancel1;

    @FXML
    private void handleCancelButton1() {
        // Handle the cancel button action
        // Navigate back to the login page

        // Get the current stage
        Stage currentStage = (Stage) btnCancel1.getScene().getWindow();

        // Load the login page FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homepage111.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Create a new scene with the login page
        Scene scene = new Scene(root);

        // Set the scene in the current stage
        currentStage.setScene(scene);
    }

    @FXML
    private Button btnCancel;

    @FXML
    private void handleCancelButton() {
        // Handle the cancel button action
        // Navigate back to the login page

        // Get the current stage
        Stage currentStage = (Stage) btnCancel.getScene().getWindow();

        // Load the login page FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Create a new scene with the login page
        Scene scene = new Scene(root);

        // Set the scene in the current stage
        currentStage.setScene(scene);
    }


    //  StoreTableController n =  new StoreTableController();
     ;
     

    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Retrieve the XML data
        RiverList data = RiverDataXML.loadData();

        XYChart.Series<String, Double> temperatureSeries = new XYChart.Series<>();
        XYChart.Series<String, Double> pHSeries = new XYChart.Series<>();
        XYChart.Series<String, Double> ammoniaSeries = new XYChart.Series<>();
        XYChart.Series<String, Double> solidSeries = new XYChart.Series<>();
        XYChart.Series<String, Double> dissolvesSeries = new XYChart.Series<>();
        XYChart.Series<String, Double> chemicalSeries = new XYChart.Series<>();
        XYChart.Series<String, Double> biologicalSeries = new XYChart.Series<>();

        // Set names for the series
        temperatureSeries.setName("Temperature");
        pHSeries.setName("pH");
        ammoniaSeries.setName("Ammonia");
        solidSeries.setName("Solid");
        dissolvesSeries.setName("Dissolved Oxygen");
        chemicalSeries.setName("Chemical Oxygen");
        biologicalSeries.setName("Biological Oxygen");

        // Populate the series with data
        for (River river : data.getData()) {
            temperatureSeries.getData().add(new XYChart.Data<>(river.getName(), river.getTemperature()));
            pHSeries.getData().add(new XYChart.Data<>(river.getName(), river.getpH()));
            ammoniaSeries.getData().add(new XYChart.Data<>(river.getName(), river.getAmmonia()));
            solidSeries.getData().add(new XYChart.Data<>(river.getName(), river.getSolid()));
            dissolvesSeries.getData().add(new XYChart.Data<>(river.getName(), river.getDissolvesOxygen()));
            chemicalSeries.getData().add(new XYChart.Data<>(river.getName(), river.getChemicalOxygen()));
            biologicalSeries.getData().add(new XYChart.Data<>(river.getName(), river.getBiologicalOxygen()));
        }

        // Clear the existing data in the BarChart
        MybarChart.getData().clear();

        // Add the series to the BarChart
        MybarChart.getData().addAll(
                temperatureSeries, pHSeries, ammoniaSeries, solidSeries,
                dissolvesSeries, chemicalSeries, biologicalSeries);

        // Count the number of rivers for each pH range
        int acidicCount = 0;
        int neutralCount = 0;
        int alkalineCount = 0;
        for (River river : data.getData()) {
            double pH = river.getpH();
            if (pH < 7) {
                acidicCount++;
            } else if (pH > 7) {
                alkalineCount++;
            } else {
                neutralCount++;
            }
        }

        // Create the PieChart and add the data
        PieChart.Data acidicData = new PieChart.Data("Acidic", acidicCount);
        PieChart.Data neutralData = new PieChart.Data("Neutral", neutralCount);
        PieChart.Data alkalineData = new PieChart.Data("Alkaline", alkalineCount);
        pieChart.getData().addAll(acidicData, neutralData, alkalineData);
    }

    public void setUserName(String userNameFromXML) {
    }



    
}
