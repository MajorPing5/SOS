package controller;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import application.App;
import backend.MenuLogic;
import backend.GameParams;

public class CtrlerMainMenu {
	@FXML private ChoiceBox<String> modeChoiceBox;
	@FXML private TextField boardSizeField;
	// @FXML private ChoiceBox<String> opponentChoiceBox;
	@FXML private Button startButton;
	@FXML private Label errorLabel;
	
	public void initialize() {
		modeChoiceBox.getItems().addAll(GameParams.GAME_MODES);
		errorLabel.setVisible(false);
	}
	
	@FXML private void handleStartGame() {
		String boardSizeText = boardSizeField.getText();
		String selectedMode = modeChoiceBox.getValue();
		
		errorLabel.setVisible(false);
		
		// Checks if game mode was selected to verify game state settings to use
		if (selectedMode == null) {
			showError("ERROR: GAME MODE MISSING. SELECT A GAME MODE");
			return;
		}
		
		
	}

	private void showError(String message) {
		errorLabel.setText(message);
		errorLabel.setTextFill(Color.RED);
		errorLabel.setVisible(true);
	}
}
