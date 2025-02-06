import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Label helloLabel = new Label("Hello, JavaFX!");
			StackPane root = new StackPane();
			root.getChildren().add(helloLabel);
			Scene scene = new Scene(root, 300, 250);
			
			primaryStage.setTitle("JavaFX Welcome");
			primaryStage.setScene(scene);
			primaryStage.show();		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
