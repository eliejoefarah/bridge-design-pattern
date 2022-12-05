import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddSavingsBox {
    static Savings mySavings = new Savings(null);

    public static void display(String title, TextField inputSavings) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        inputSavings.setMinWidth(100);

        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 20;");
        addButton.setOnAction(e -> {
            try {
                Savings.addSavings(Double.parseDouble(inputSavings.getText()));
                window.close();
            } catch (NumberFormatException g) {
                AlertBox.display("No!", "Input must be a number");
            }

        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputSavings, addButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);
        window.showAndWait();
    }

}
