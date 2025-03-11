package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
// import application.App;
import backend.MenuLogic;
import backend.GameParams;

public class CtrlerMainMenu {
	@FXML
	private ChoiceBox<String> cbMode;
	@FXML
	private TextField tfboardSize;
	// @FXML private ChoiceBox<String> opponentChoiceBox;
	@FXML
	private Button startButton;
	@FXML
	private Label errorLabel;
	
	@FXML
	protected void gameStart(ActionEvent e) {
		
	}
	
	public void initialize() {
		cbMode.getItems().addAll(GameParams.GAME_MODES);
		errorLabel.setVisible(false);
	}
	
	@FXML private void handleStartGame() {
		String boardSizeText = tfboardSize.getText();
		String selectedMode = cbMode.getValue();
		
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
