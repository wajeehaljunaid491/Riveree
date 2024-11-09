package riveree.lab;

import java.io.Serializable;


import javafx.beans.property.*;

public class River implements Serializable{
    
    
    private StringProperty name;
    public String getName() {
        return name.get();
    }
    public void setName(String n) {
        this.name.set(n);
    }
    public StringProperty nameProperty() {
        return name;
    }
    
    private StringProperty location;
    
    public String getLocation() {
        return location.get();
    }
    public void setLocation(String location) {
        this.location.set(location);
    }
    public StringProperty locationProperty() {
        return location;
    }
    
    private DoubleProperty pH;
    
    public double getpH() {
        return pH.get();
    }
    public void setpH(double pH) { 
        this.pH.set(pH);
    }
    public DoubleProperty pHProperty() {
        return pH;
    }
    
    private DoubleProperty temperature;
    public double getTemperature() {
        return temperature.get();
    }
    public void setTemperature(double temperature) {
        this.temperature.set(temperature);
    }
    public DoubleProperty temperatureProperty() {
        return temperature;
    }
    
    private DoubleProperty ammonia;
    public double getAmmonia() {
        return ammonia.get();
    }
    public void setAmmonia(double ammonia) {
        this.ammonia.set(ammonia);
    }
    public DoubleProperty ammoniaProperty() {
        return ammonia;
    }
    
    private DoubleProperty solid;
    public double getSolid() {
        return solid.get();
    }
    public void setSolid(double solid) {
        this.solid.set(solid);
    }
    public DoubleProperty solidProperty() {
        return solid;
    }
    
    private StringProperty observer;
    public String getObserver() {
        return observer.get();
    }
    public void setObserver(String observer) {
        this.observer.set(observer);
    }
    public StringProperty observerProperty() {
        return observer;
    }
    
    private StringProperty date;
    public String getDate() {
        return date.get();
    }
    public void setDate(String date) {
        this.date.set(date);
    }
    public StringProperty dateProperty() {
        return date;
    }
    
    private StringProperty conclusion;
    public String getConclusion() {
        return conclusion.get();
    }
    public void setConclusion(String conclusion) {
        this.conclusion.set(conclusion);
    }
    public StringProperty conclusionProperty() {
        return conclusion;
    }
    
    private DoubleProperty dissolvesOxygen;
    public double getDissolvesOxygen() {
        return dissolvesOxygen.get();
    }
    public void setDissolvesOxygen(double dissolvesOxygen) {
        this.dissolvesOxygen.set(dissolvesOxygen);
    }
    public DoubleProperty dissolvesOxygenProperty() {
        return dissolvesOxygen;
    }
    
    private DoubleProperty chemicalOxygen;
    public double getChemicalOxygen() {
        return chemicalOxygen.get();
    }
    public void setChemicalOxygen(double chemicalOxygen) {
        this.chemicalOxygen.set(chemicalOxygen);
    }
    public DoubleProperty chemicalOxygenProperty() {
        return chemicalOxygen;
    }
    
    private DoubleProperty biologicalOxygen;
    public double getBiologicalOxygen() {
        return biologicalOxygen.get();
    }
    public void setBiologicalOxygen(double biologicalOxygen) {
        this.biologicalOxygen.set(biologicalOxygen);
    }
    public DoubleProperty biologicalOxygenProperty() {
        return biologicalOxygen;
    }
    
    public River(String name, String location, double pH, double temperature, double ammonia, double solid,
                 String observer, String date, double dissolvesOxygen, double chemicalOxygen, double biologicalOxygen,
                 String conclusion) {
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
        this.pH = new SimpleDoubleProperty(pH);
        this.temperature = new SimpleDoubleProperty(temperature);
        this.ammonia = new SimpleDoubleProperty(ammonia);
        this.solid = new SimpleDoubleProperty(solid);
        this.observer = new SimpleStringProperty(observer);
        this.date = new SimpleStringProperty(date);
        this.dissolvesOxygen = new SimpleDoubleProperty(dissolvesOxygen);
        this.chemicalOxygen = new SimpleDoubleProperty(chemicalOxygen);
        this.biologicalOxygen = new SimpleDoubleProperty(biologicalOxygen);
        this.conclusion = new SimpleStringProperty(conclusion);
    }
    
    public River() {
        this("", "", 0, 0, 0, 0, "", "", 0, 0, 0, "");
    }
}
