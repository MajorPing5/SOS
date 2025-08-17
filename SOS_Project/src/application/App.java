package application;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import controller.CtrlerMainMenu;
import view.*;
import model.*;
import util.*;

// Should be focused on being the manager of scene transition and state management
public class App extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		SceneSwap.sceneSwap(
				primaryStage,
				"/gui/MainMenu.fxml",
				MenuView.class,
				MenuModel.class,
				(view, model) -> new CtrlerMainMenu(view, model)
				);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
