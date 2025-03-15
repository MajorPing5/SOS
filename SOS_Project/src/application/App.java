package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import controller.CtrlerMainMenu;
import model.GameParams;
// Should be focused on being the manager of scene transition and state management
public class App extends Application{
	private static Stage primaryStage;
	private static GameParams gameSettings;
	
	// Getters & Setters
	public static GameParams getGameSettings() {
		return gameSettings;
	}	
	
	// Custom Methods
	/**
	 * Dedicated custom method for scene switching
	 * @param fxmlFileName
	 * @param settings
	 */
	public static void switchToScene(String fxmlFileName, GameParams settings) {
		try {
			if (settings != null) {
				gameSettings = settings;
			}
			// String concatenation for the fxml file, assuming all scenes are stored in GUI
			FXMLLoader loader = new FXMLLoader(App.class.getResource("/GUI/" + fxmlFileName));
			Parent root = loader.load();
			primaryStage.setScene(new Scene(root));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	// Initializes the opening stage when the program first begins
	@Override
	public void start(Stage stage) {
		primaryStage = stage;
		primaryStage.setTitle("SOS Game");
		switchToScene("MainMenu.fxml", null);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// new MainMenu window
		launch(args);
	}
}
