// package riveree.lab;

// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;

// public class Riverlist1 {
//     private ObservableList<River> dataList;

//     public Riverlist1() {
//         dataList = FXCollections.observableArrayList();
//     }

//     public ObservableList<River> getData() {
//         return dataList;
//     }

//     public void setData(String name, String location, double ph, double temperature,
//                         double ammonia, double solid, String observer, String date,
//                         double dissolves, double chemical, double biological,
//                         String conclusion) {
//         dataList.add(new River(
//                 name, location, ph, temperature, ammonia, solid, observer, date,
//                 dissolves, chemical, biological, conclusion
//         ));
//     }

//     public void remove(River river) {
//         dataList.remove(river);
//     }

//     public void clear() {
//         dataList.clear();
//     }

//     public void updateRiver(River updatedRiver) {
//         int index = dataList.indexOf(updatedRiver);
//         if (index != -1) {
//             dataList.set(index, updatedRiver);
//         }
//     }
    
// }



package riveree.lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RiverList {
    private ObservableList<River> dataList;

    public RiverList() {
        dataList = FXCollections.observableArrayList();
    }

    public ObservableList<River> getData() {
        return dataList;
    }

    public void setData(String name, String location, double pH, double temperature,
                        double ammonia, double solid, String observer, String date,
                        double dissolvesOxygen, double chemicalOxygen, double biologicalOxygen,
                        String conclusion) {
        dataList.add(new River(
                name, location, pH, temperature, ammonia, solid, observer, date,
                dissolvesOxygen, chemicalOxygen, biologicalOxygen, conclusion
        ));
    }
    public void setDummy() {
       

    }

   

    public void clear() {
        dataList.clear();
    }

    // public void updateRiver(River updatedRiver) {
    //     int index = dataList.indexOf(updatedRiver);
    //     if (index != -1) {
    //         dataList.set(index, updatedRiver);
    //     }
    // }
}

