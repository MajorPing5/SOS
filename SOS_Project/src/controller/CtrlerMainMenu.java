package controller;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.GameParams;
import model.MenuModel;

// Focus should be on communication between MainMenuModel and MainMenuView
public class CtrlerMainMenu {
	@FXML
	private ChoiceBox<String> cbMode;
	@FXML
	private TextField txtBoardSize;
	// @FXML private ChoiceBox<String> opponentChoiceBox;
	@FXML
	private Button startButton;
	@FXML
	private Label errorLabel;
	
	public void initialize() {
		cbMode.getItems().addAll(MenuModel.GAME_MODES);
	}
	
	@FXML private void handleStartGame() {
		String boardSizeText = txtBoardSize.getText();
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
	
	public void reset() {
		txtBoardSize.clear();
		cbMode.setValue(null);
		errorLabel.setVisible(false);
	}
}
