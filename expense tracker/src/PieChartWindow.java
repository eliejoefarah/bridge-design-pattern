
import java.util.ArrayList;
import java.util.Map;
//import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PieChartWindow extends Payment {

    public static void display(String title) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        // Set<String> setOfNames = ItemMap.keySet();
        // String[] names = new String[setOfNames.size()];
        // int i = 0;
        // for (String name : setOfNames) {
        // names[i] = name;
        // ++i;
        // }
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(new ArrayList<PieChart.Data>());

        for (Map.Entry<String, Double> entry : ItemMap.entrySet()) {
            pieData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }

        PieChart pChart = new PieChart(pieData);
        Label sumLab = new Label(Summary.getCurrentSummary());
        GridPane root = new GridPane();
        GridPane.setConstraints(pChart, 5, 5);
        GridPane.setConstraints(sumLab, 15, 30);
        root.getChildren().addAll(pChart, sumLab);
        Scene scene = new Scene(root, 1000, 800);
        window.setScene(scene);
        window.showAndWait();

    }
}
