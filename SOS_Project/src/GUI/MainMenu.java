package GUI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainMenu extends Application{
	
	@Override
	public void start(Stage menuStage) throws Exception{
		/** 
		 * HBox gameSettings = new HBox();
		 * HBox.setHgrow( gameSettings, Priority.ALWAYS );
		 * gameSettings.setAlignment( Pos.CENTER );
		 * 
		 * ChoiceBox gameMode new ChoiceBox();
		 * gameMode.getItems().add(
		 * 
		 * VBox mainVBox = new VBox();
		 * VBox.setVgrow ( mainVBox, Priority.ALWAYS );
		 * mainVBox.setAlignment ( Pos.CENTER );
		 * 
		 * Button submitButton = new Button("Submit");
		 * 
		 * mainVBox.getChildren().addAll ( gameSettings, submitButton );
		 *  
		 * button.setOnAction(event -> {
		 * 	// button pressed
		 * });
		 */
		
		Circle circ = new Circle(40, 40, 30);
		Group root = new Group(circ);
		Scene scene = new Scene(root, 400, 300);
		
		menuStage.setTitle("SOS Project");
		menuStage.setScene(scene);
		menuStage.show();
	}
	
}
