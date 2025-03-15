package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.GameParams;
import model.MenuModel;

// Focus should be on communication transport between MainMenuModel and MainMenuView
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
	
	private MenuModel model;
	private GameParams params;
	
	Map<String, Object> inputFields;
	
	public void initialize() {
		cbMode.getItems().addAll(MenuModel.GAME_MODES);
		
		inputFields = new HashMap<>();
	}
	
	@FXML private void handleStartGame() {
		
		inputFields.put("boardSize", txtBoardSize.getText());
		inputFields.put("gameMode", cbMode.getValue());
		
		List<String> invalidFields = new ArrayList<>();
		errorLabel.setVisible(false);
		
		inputFields.forEach((fieldName, value) -> {
			if (value == null) {
				invalidFields.add(fieldName);
			} else if (fieldName.equals("boardSize")) {
				model.validateBoardSize(value.toString());
			}
		});
		
		// If empty, all fields are valid and accepted
		if (!invalidFields.isEmpty()) {
			showError("ERROR: The following feilds contained invalid information: " +
					String.join(", ", invalidFields));
			return;
		}
		int boardSize = (Integer) inputFields.get("boardSize");
		String gameMode = (String) inputFields.get("gameMode");
		
		App.startGame(new GameParams(boardSize, gameMode, "Human"));
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
