package riveree;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SampleData {

    private final StringProperty name;
    private final StringProperty location;
    private final StringProperty pH;

    // Add more properties for additional columns

    public SampleData(String name, String location, String pH) {
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
        this.pH = new SimpleStringProperty(pH);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty locationProperty() {
        return location;
    }

    public StringProperty phProperty() {
        return pH;
    }

    public void setName(String name2) {
    }

    public void setLocation(String location2) {
    }

    public void setPh(String ph2) {
    }

    public String getName() {
        return null;
    }

    public String getLocation() {
        return null;
    }

    public String getPh() {
        return null;
    }

    // Add getter and setter methods for additional properties
}

