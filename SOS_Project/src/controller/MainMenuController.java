package controller;
import Back_End_Logic.MenuLogic;
import javafx.fxml.*;
import javafx.scene.control.*;

public class MainMenuController {
	@FXML
	private ChoiceBox<String> modeChoiceBox;
	
	public void initialize() {
		modeChoiceBox.setItems(MenuLogic.GAME_MODES);
	}
}
