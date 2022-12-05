import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddEarningsBox {
    static Savings mySavings = new Savings(null);
    static Earnings earnings = new Earnings();

    public static void display(String title, TextField inputEarnings) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        inputEarnings.setMinWidth(100);

        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 20;");
        addButton.setOnAction(e -> {
            try {
                if (Savings.addBudget(Double.parseDouble(inputEarnings.getText()))) {
                    earnings.Expense(Double.parseDouble(inputEarnings.getText()));
                    window.close();
                } else {
                    AlertBox.display("No!", "Not enough savings");
                }
            } catch (NumberFormatException h) {
                AlertBox.display("No!", "Input must be a number");
            }

        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(inputEarnings, addButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);
        window.showAndWait();
    }

}
