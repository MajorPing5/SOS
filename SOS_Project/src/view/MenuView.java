package view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuView {
	// Fields
	@FXML private ChoiceBox<String> cbMode;
	@FXML private TextField txtBoardSize;
	@FXML private ChoiceBox<String> cbOp;
	@FXML private Button btnStart;
	@FXML private Label errorLabel;

	public MenuView() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Provides cbMode value from choice box
	 * 
	 * @return the cbMode as a string
	 */
	public String getCBModeChoice() {
		return cbMode.getValue();
	}

	/**
	 * Provides board size from boardSize text field
	 * 
	 * @return the txtBoardSize as a string
	 */
	public String getTxtBoardSize() {
		return txtBoardSize.getText();
	}

	/**
	 * Provides opponent choice from choice box
	 * 
	 * @return the cbOpponent as a string
	 */
	public String getCBOpponent() {
		return cbOp.getValue();
	}

	public Button getBtnStart() {
		return btnStart;
	}

	public Stage getStage() {
		return (Stage) btnStart.getScene().getWindow();
	}

	/** 
	 * Fills Game Mode options from choice box with provided list info from Model 
	 * 
	 * @param gameModes A list of Strings containing all game modes offered
	 */
	public void setCBModeOptions(List<String> gameModes) {
		ObservableList<String> cbModeList =
				FXCollections.observableArrayList(gameModes);
		cbMode.setItems(cbModeList);
	}

	// Custom Methods
	/**
	 * Small method to display any error message
	 * 
	 * @param message
	 */
	public void showError(String message) {
		errorLabel.setText(message);
		errorLabel.setTextFill(Color.RED);
		displayError(true);
	}

	public void hideError() {
		displayError(false);
	}

	/** Small method to clear all fields */
	public void reset() {
		txtBoardSize.clear();
		cbMode.setValue(null);
		hideError();
	}

	private void displayError(boolean show) {
		errorLabel.setVisible(show);
	}
}