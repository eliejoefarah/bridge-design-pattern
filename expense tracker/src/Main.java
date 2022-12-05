
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	Button button;
	Stage window;
	Scene scene1, addSavingsScene;
	ComboBox<String> cb = new ComboBox<>();
	TextField priceInput, dateInput;
	TableView<Item> table;
	Earnings e = new Earnings();
	Savings mySavings = new Savings(e);

	public static void main(String[] args) {

		launch(args);

		// Savings MySavings = new Savings();

		// System.out.println(MySavings.getSavings());

		// Savings.addSavings(200);
		// System.out.println(MySavings.getSavings());

		// MySavings.setBudget(100);

		// System.out.println(MySavings.getBudget());

		/// Payement.ItemPurchase(25, "Shoes");

		/// Payement.ItemPurchase(35, "Shoes");

		// System.out.println(Savings.HowMuchLeft());

		// Savings.LatestPurchase();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("Expense Tracker Main Window");

		cb = new ComboBox<>();
		cb.getItems().addAll(
				"Food",
				"Trasportation",
				"Rent",
				"Education",
				"Leisure",
				"Utilities");
		cb.setEditable(true);
		cb.setPromptText("enter item name");
		cb.setMinWidth(250);

		TableColumn<Item, String> nameCol = new TableColumn<>("Type");
		nameCol.setMinWidth(250);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("type"));

		TableColumn<Item, Double> priceCol = new TableColumn<>("Price");
		priceCol.setMinWidth(200);
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<Item, Integer> budgetRemCol = new TableColumn<>("Budget Remainder");
		budgetRemCol.setMinWidth(200);
		budgetRemCol.setCellValueFactory(new PropertyValueFactory<>("budgetRem"));

		TableColumn<Item, Integer> savingsRemCOl = new TableColumn<>("Savings Remainder");
		savingsRemCOl.setMinWidth(200);
		savingsRemCOl.setCellValueFactory(new PropertyValueFactory<>("savingsRem"));

		priceInput = new TextField();
		priceInput.setPromptText("enter item price");
		priceInput.setMinWidth(200);

		Button add = new Button("Add");
		add.setOnAction(e -> addClicked());

		Button quit = new Button("Quit");
		quit.setOnAction(e -> quitClicked());

		Button addSavings = new Button("Add Savings");
		addSavings.setOnAction(e -> addSavingsClicked());

		// Button export = new Button("Export");
		// export.setOnAction(e -> exportClicked());

		Button summarize = new Button("Generate Summary");
		summarize.setOnAction(e -> summarizeClicked());

		Button addEarn = new Button("Add to budget");
		addEarn.setOnAction(e -> addEarnClicked());

		HBox addDelete = new HBox();
		addDelete.setPadding(new Insets(10, 10, 10, 10));
		addDelete.setSpacing(10);
		addDelete.getChildren().addAll(cb, priceInput, add, quit);
		addDelete.setAlignment(Pos.CENTER);

		HBox savGen = new HBox();
		savGen.setPadding(new Insets(10, 10, 10, 10));
		savGen.setSpacing(10);
		savGen.getChildren().addAll(addEarn, addSavings, summarize);
		savGen.setAlignment(Pos.CENTER);

		VBox buttons = new VBox(10);
		buttons.setPadding(new Insets(10, 10, 10, 10));
		buttons.getChildren().addAll(addDelete, savGen);
		savGen.setAlignment(Pos.CENTER);

		table = new TableView<>();
		// table.setItems(getProduct());
		table.getColumns().addAll(nameCol, priceCol, budgetRemCol, savingsRemCOl);

		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.getChildren().addAll(table, buttons);
		Scene tableScene = new Scene(vbox);
		tableScene.getStylesheets().add("StyleSheet.css");

		Button addNewSaving = new Button("Add");
		addNewSaving.setOnAction(e -> {
			window.setScene(tableScene);

		});

		// initial page
		Label welcome = new Label("Expense Tracker");

		Label initialSavings = new Label("Initial Savings: ");
		TextField savingsInput = new TextField();
		savingsInput.setMaxWidth(200);
		HBox input1 = new HBox(20);
		input1.getChildren().addAll(initialSavings, savingsInput);
		input1.setAlignment(Pos.CENTER);
		savingsInput.setPromptText("Enter initial savings");

		Label initialBudget = new Label("Initial Budget: ");
		TextField budgetInput = new TextField();
		budgetInput.setMaxWidth(200);
		budgetInput.setPromptText("Enter Budget");
		HBox input2 = new HBox(20);
		input2.setAlignment(Pos.CENTER);
		input2.getChildren().addAll(initialBudget, budgetInput);

		Button start = new Button("Start");
		start.setOnAction(e -> {
			try {
				if (Double.parseDouble(savingsInput.getText()) >= Double.parseDouble(budgetInput.getText())) {

					mySavings.setSavings(Double.parseDouble(savingsInput.getText()));
					mySavings.setBudget(Double.parseDouble(budgetInput.getText()));

					window.setScene(tableScene);

				} else {
					AlertBox.display("No!", "Budget must be less than or equal to the savings");
				}
			} catch (NumberFormatException f) {
				AlertBox.display("No!", "Input must be a number");
			}
		});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(welcome, input1, input2, start);
		layout.setAlignment(Pos.CENTER);
		Scene welcomeScene = new Scene(layout, 400, 300);
		welcomeScene.getStylesheets().add("StyleSheet.css");
		// layout.getStylesheets().add("static/StyleSheet.css");
		window.setScene(welcomeScene);
		window.show();

		start.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-background-radius: 20;");
		add.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-background-radius: 20;");

		addSavings.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 20;");

		summarize.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius: 20;");
		addEarn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;-fx-background-radius : 20;");

		// text1.setStyle("-fx-font: normal bold 20px 'serif' ");
		// text2.setStyle("-fx-font: normal bold 20px 'serif' ");

	}

	private void addEarnClicked() {
		TextField inputEarnings = new TextField();
		inputEarnings.setMaxWidth(200);
		AddEarningsBox.display("Add to the Budget", inputEarnings);
	}

	private void summarizeClicked() {
		PieChartWindow.display("Summary");

	}

	private void addSavingsClicked() {
		TextField inputSavings = new TextField();
		inputSavings.setMaxWidth(200);
		AddSavingsBox.display("Add your new savings", inputSavings);
	}

	private void quitClicked() {
		if (ConfirmBox.display("Confirm", "Are you sure you want to quit?"))
			window.close();

		Payment.ItemMap.clear();
	}

	private void addClicked() {
		try {
			Item item = new Item();
			String type = cb.getValue();
			Double price = Double.parseDouble(priceInput.getText());

			if (Payment.ItemPurchase(price, type)) {
				item.setType(type);
				item.setPrice(price);
				item.setBudgetRem(Savings.HowMuchLeft());
				item.setSavingsRem(mySavings.getSavings());
				table.getItems().add(item);

				ObservableList<Item> allItems;
				allItems = table.getItems();
				// allItems.forEach();

			} else {
				AlertBox.display("Oops!", "You have exceeded your budget");
			}

			System.out.println(Savings.HowMuchLeft());
			cb.getSelectionModel().clearSelection();
			priceInput.clear();
			dateInput.clear();
		} catch (NumberFormatException e) {
			AlertBox.display("No!", "Input must be a number!");
		}

	}

}
