package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class GameView {
	// Fields
	@FXML private GridPane gameBoard;
	@FXML private ToggleGroup p1RadioGroup;
	@FXML private ToggleGroup p2RadioGroup;
	@FXML private RadioButton player1S;
	@FXML private RadioButton player1O;
	@FXML private RadioButton player2S;
	@FXML private RadioButton player2O;
	@FXML private Label txtGameMode;
	@FXML private Label txtBoardSize;

	// Constructors
	public GameView() {}

	// Getters & Setters
	/**
	 * @return the gameBoard
	 */
	public GridPane getGameBoard() {
		return gameBoard;
	}

	/**
	 * @return the p1RadioGroup
	 */
	public ToggleGroup getP1RadioGroup() {
		return p1RadioGroup;
	}

	/**
	 * @return the p2RadioGroup
	 */
	public ToggleGroup getP2RadioGroup() {
		return p2RadioGroup;
	}

	/**
	 * @return the player1S
	 */
	public RadioButton getPlayer1S() {
		return player1S;
	}

	/**
	 * @return the player1O
	 */
	public RadioButton getPlayer1O() {
		return player1O;
	}

	/**
	 * @return the player2S
	 */
	public RadioButton getPlayer2S() {
		return player2S;
	}

	/**
	 * @return the player2O
	 */
	public RadioButton getPlayer2O() {
		return player2O;
	}

	/**
	 * @return the txtGameMode
	 */
	public Label getTxtGameMode() {
		return txtGameMode;
	}

	/**
	 * @return the txtBoardSize
	 */
	public Label getTxtBoardSize() {
		return txtBoardSize;
	}

	/**
	 * @param gameBoard the gameBoard to set
	 */
	public void setGameBoard(GridPane gameBoard) {
		this.gameBoard = gameBoard;
	}

	/**
	 * @param p1RadioGroup the p1RadioGroup to set
	 */
	public void setP1RadioGroup(ToggleGroup p1RadioGroup) {
		this.p1RadioGroup = p1RadioGroup;
	}

	/**
	 * @param p2RadioGroup the p2RadioGroup to set
	 */
	public void setP2RadioGroup(ToggleGroup p2RadioGroup) {
		this.p2RadioGroup = p2RadioGroup;
	}

	/**
	 * @param player1s the player1S to set
	 */
	public void setPlayer1S(RadioButton player1s) {
		player1S = player1s;
	}

	/**
	 * @param player1o the player1O to set
	 */
	public void setPlayer1O(RadioButton player1o) {
		player1O = player1o;
	}

	/**
	 * @param player2s the player2S to set
	 */
	public void setPlayer2S(RadioButton player2s) {
		player2S = player2s;
	}

	/**
	 * @param player2o the player2O to set
	 */
	public void setPlayer2O(RadioButton player2o) {
		player2O = player2o;
	}

	/**
	 * @param txtGameMode the txtGameMode to set
	 */
	public void setTxtGameMode(Label txtGameMode) {
		this.txtGameMode = txtGameMode;
	}

	/**
	 * @param txtBoardSize the txtBoardSize to set
	 */
	public void setTxtBoardSize(Label txtBoardSize) {
		this.txtBoardSize = txtBoardSize;
	}
}
