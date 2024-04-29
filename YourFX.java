// YourFX.java by Steven Conyers

package YourFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class YourFX extends Application {

	// Create a TextField for input.
	private TextField gHours;
	private TextField gName;

	// Create labels to display result
	private Label lSuggestion;
	private Label lStats;

	public static void main(String[] args) {
		// Application launch
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Create image
		Image pc = new Image("file:pcsetup.jpg");

		ImageView pcView = new ImageView(pc);

		// Sizing image
		pcView.setFitWidth(500);
		pcView.setFitHeight(500);
		pcView.setPreserveRatio(true);

		// Create a Label to display a prompts.
		Label lHours = new Label("What is the most hours you've spent on one particular game in a year?");

		Label lGame = new Label("What is the name of this game?");

		// Creates TextField's for user input.
		gHours = new TextField();

		gName = new TextField();

		// Empty labels to display results
		lSuggestion = new Label();

		lStats = new Label();

		// Create a Button to perform the conversion.
		Button hrsCalc = new Button("Get Weekly Average");

		// Create ToggleGroup
		ToggleGroup myToggleGroup = new ToggleGroup();

		// Create choice buttons
		RadioButton radio1 = new RadioButton("Animal Crossing");
		RadioButton radio2 = new RadioButton("Forza 5");
		RadioButton radio3 = new RadioButton("Zelda");

		// Add buttons to ToggleGroup
		radio1.setToggleGroup(myToggleGroup);
		radio2.setToggleGroup(myToggleGroup);
		radio3.setToggleGroup(myToggleGroup);

		radio1.setOnAction(event -> {
			lStats.setMaxWidth(290);
			lStats.setWrapText(true);
			lStats.setText("This game is rated #1 of 30 games that has the most hours "
					+ "needed to complete, with an average of 422 hours.");
		});
		radio2.setOnAction(event -> {
			lStats.setMaxWidth(290);
			lStats.setWrapText(true);
			lStats.setText("With around 200 vehicles to collect and choose from, "
					+ "this game requires around 69 hours to complete.");
		});
		radio3.setOnAction(event -> {
			lStats.setMaxWidth(290);
			lStats.setWrapText(true);
			lStats.setText("The Zelda francise has been going on since Nintendo's first release in 1986. "
					+ "With Zelda: Breath of The Wild, it takes an average of 46 hours to complete the campaign.");
		});

		// Create a ListView of Strings.
		ListView<String> platformList = new ListView<>();
		platformList.setPrefSize(0, 50);
		platformList.getItems().addAll("PC", "Playstation 5", "Xbox Series X", "Nintendo Switch", "Mobile Gaming");

		// Create label to display selection from list
		Label selectedPlatform = new Label("Choose from above...");

		// Creates button for list
		Button choice = new Button("Replies to Selection");

		// Event handler for list button
		choice.setOnAction(event -> {
			if (platformList.getSelectionModel().getSelectedIndex() == 0) {
				// Get selection

				selectedPlatform.setText("PC Master Race. Perfect choice!");
			} else if (platformList.getSelectionModel().getSelectedIndex() == 1) {
				// Get selection

				selectedPlatform.setText("Sony fanboy huh?");
			} else if (platformList.getSelectionModel().getSelectedIndex() == 2) {
				// Get selection

				selectedPlatform.setText("Team Xbox!");
			} else if (platformList.getSelectionModel().getSelectedIndex() == 3) {
				// Get selection

				selectedPlatform.setText("Nintendo Switch? That's childsplay.");
			} else if (platformList.getSelectionModel().getSelectedIndex() == 4) {
				// Get selection

				selectedPlatform.setText("Moblie gaming? Let me guess, Angry Birds?!!");
			} else {
				selectedPlatform.setText("No platform chosen.");
			}
		});

		// Create a ComboBox selection.
		ComboBox<String> oldSchool = new ComboBox<>();
		oldSchool.getItems().addAll("NES", "SEGA", "Atari 2600", "ColecoVision");

		// Create label for combobox
		Label oldSystem = new Label("Select a Console");

		// Create a button
		Button conInfo = new Button("Test Console Button");

		// Event handler for combobox button
		conInfo.setOnAction(event -> {
			oldSystem.setText(oldSchool.getValue());
		});

		// Register the event handler.
		hrsCalc.setOnAction(new okHoursHandler());

		// Put prompt first, last, StuNum in HBox's
		HBox hbox1 = new HBox(10, lHours, gHours);

		// Put HBox, createUser button and userLabel in VBox
		VBox vbox1 = new VBox(10, hbox1, hrsCalc, lSuggestion);

		// Align Vbox's
		vbox1.setAlignment(Pos.TOP_CENTER);

		// Set the VBox's padding to 10 pixels.
		vbox1.setPadding(new Insets(15));

		// Create Gridpane
		GridPane gridpane = new GridPane();
		gridpane.setHgap(20);
		gridpane.setVgap(20);

		// Organize Gridpane
		gridpane.add(lHours, 0, 0);
		gridpane.add(gHours, 2, 0);
		gridpane.add(lGame, 0, 1);
		gridpane.add(gName, 2, 1);
		gridpane.add(hrsCalc, 2, 2);
		gridpane.add(lSuggestion, 0, 3);
		gridpane.add(radio1, 0, 5);
		gridpane.add(radio2, 0, 6);
		gridpane.add(radio3, 0, 7);
		gridpane.add(lStats, 0, 9);
		gridpane.add(platformList, 0, 11);
		gridpane.add(selectedPlatform, 0, 12);
		gridpane.add(choice, 0, 13);
		gridpane.add(conInfo, 0, 15);
		gridpane.add(oldSchool, 0, 16);
		gridpane.add(oldSystem, 0, 17);
		gridpane.add(pcView, 0, 10);

		// Create a Scene.
		Scene scene = new Scene(gridpane, 1300, 1300);
		scene.getStylesheets().add("YourFX/pcsetup.css");

		// Add the Scene to the Stage.
		primaryStage.setScene(scene);

		// Set the stage title.
		primaryStage.setTitle("Gaming Stats by Steven Conyers");

		// Show the window.
		primaryStage.show();
	}

	/*
	 * Event handler class
	 */

	class okHoursHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// Get the textfield data
			double gameHrs = Double.parseDouble(gHours.getText());
			String Game = gName.getText();

			// Declaration for weeks in a year
			double weeks = 52.00;

			// Calculation of hours by weeks a year
			double weekGaming = gameHrs / weeks;

			if (weekGaming <= 42) {

				// Display the results.
				lSuggestion.setMaxWidth(400);
				lSuggestion.setWrapText(true);
				lSuggestion.setText("On average, you've only spent " + String.format("%,.2f", weekGaming)
						+ " hours a week playing " + Game + "." + "\nBusy life huh? That's rookie numbers!");
			} else if (weekGaming > 84) {
				// Display the results.
				lSuggestion.setMaxWidth(290);
				lSuggestion.setWrapText(true);
				lSuggestion.setText("On average, you've spent " + String.format("%,.2f", weekGaming)
						+ " hours on a week playing " + Game + "." + " \nWOW!!! Are you a professional gamer?");

			}
		}
	}
}