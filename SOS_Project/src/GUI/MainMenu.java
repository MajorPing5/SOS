package GUI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainMenu extends Application{
	public void start(Stage stage) {
		/**
		 * Button button =
		 * button.setOnAction(event -> {
		 * 	// button pressed
		 * });
		 */
		
		Circle circ = new Circle(40, 40, 30);
		Group root = new Group(circ);
		Scene scene = new Scene(root, 400, 300);
		
		stage.setTitle("SOS Project");
		stage.setScene(scene);;
		stage.show();
	}
	
}
