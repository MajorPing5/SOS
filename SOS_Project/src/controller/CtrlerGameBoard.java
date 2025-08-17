package controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import model.GameModel;
import view.GameView;

public class CtrlerGameBoard {
	// Fields for Class
	private int boardSize;
	private String gameMode;
	private String opponentType;

	private GameView view;
	private GameModel model;

	public CtrlerGameBoard() {
	};

	public CtrlerGameBoard(GameView view, GameModel model) {
		this.view = view;
		this.model = model;

		view.getTxtGameMode().setText(gameMode);
		view.getTxtBoardSize().setText(String.valueOf(boardSize));

		if (boardSize > 2) {
			System.out.println("Recorded boardSize integer: " + boardSize);
			buildGrid(boardSize);
		} else {
			printConstraints();
		}
	}

	public void printConstraints() {
		System.out.println("--- Grid Constraints ---");

		// Print row constraints
		System.out.println("Rows:");
		for (int i = 0; i < view.getGameBoard().getRowConstraints().size(); i++) {
			RowConstraints row = view.getGameBoard().getRowConstraints().get(i);
			double percentHeight = row.getPercentHeight();
			System.out.printf("  Row %d: %.2f%% height%n", i, percentHeight);
		}

		// Print column constraints
		System.out.println("Columns:");
		for (int i = 0; i < view.getGameBoard().getColumnConstraints().size(); i++) {
			ColumnConstraints col = view.getGameBoard().getColumnConstraints().get(i);
			double percentWidth = col.getPercentWidth();
			System.out.printf("  Column %d: %.2f%% width%n", i, percentWidth);
		}

		System.out.println("-------------------------");
	}

	/**
	 * On Action method for New Game button in Menu Bar
	 * 
	 * @param a On-Click ActionEve)nt
	 */
	@FXML
	public void newGame(ActionEvent a) {
		try {
			// Load MainMenu.fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainMenu.fxml"));
			Parent root = loader.load();

			// Obtain the parent stage to reference
			Stage stage = getStage(a);

			// Set and Display the Menu View
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			String errorDetails = parseException(e);
			System.out.println(errorDetails);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void quitGame(ActionEvent a) {
		Stage stage = getStage(a);
		stage.close();

		Platform.exit();
	}

	/**
	 * 
	 * @param boardSize
	 */

	/*
	 * private void buildGrid(int boardSize) { // Set equal row/column sizing double
	 * sizePercent = 100.0 / boardSize; for (int i = 0; i < boardSize; i++) {
	 * RowConstraints row = new RowConstraints(); row.setPercentHeight(sizePercent);
	 * gameBoard.getRowConstraints().add(row);
	 * 
	 * ColumnConstraints col = new ColumnConstraints();
	 * col.setPercentWidth(sizePercent); gameBoard.getColumnConstraints().add(col);
	 * }
	 * 
	 * // Add new cells for (int row = 0; row < boardSize; row++) { for (int col =
	 * 0; col < boardSize; col++) { Pane cell = new Pane(); gameBoard.add(cell, col,
	 * row); // Add to grid } } }
	 */

	private void buildGrid(int targetSize) {
		// Update constraints
		double sizePercent = 100.0 / targetSize;
		System.out.println("Recorded Target Size (should be same as boardSize): " + targetSize);
		System.out.println("Recorded Size Percent (should be same as boardSize): " + targetSize);

		for (int i = 0; i < targetSize; i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(sizePercent);
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth(sizePercent);
			if (i >= 3) {
				view.getGameBoard().getRowConstraints().add(row);
				view.getGameBoard().getColumnConstraints().add(col);
			} else {
				// Resize existing rows/columns (0-2)
				view.getGameBoard().getRowConstraints().get(i).setPercentHeight(sizePercent);
				view.getGameBoard().getColumnConstraints().get(i).setPercentWidth(sizePercent);
			}
		}

		// Add new cells (rows/columns >= 3)
		for (int row = 0; row < targetSize; row++) {
			for (int col = 0; col < targetSize; col++) {
				if (row >= 3 || col >= 3) {
					Pane cell = new Pane();
					view.getGameBoard().add(cell, col, row);
				}
			}
		}
	}

	private Stage getStage(ActionEvent e) {
		// Get the Stage from the MenuItem's hierarchy
		MenuItem item = (MenuItem) e.getSource();
		ContextMenu menu = item.getParentPopup(); // Get the parent ContextMenu
		Node menuBar = menu.getOwnerNode(); // Get the owner node (e.g., MenuBar)
		Stage stage = (Stage) menuBar.getScene().getWindow(); // Get the Stage

		return stage;
	}

	// Helper method to generate descriptive error messages
	private String parseException(IOException e) {
		Throwable cause = e.getCause();

		// Handle FXML file not found
		if (e.getMessage().contains("Location is not set")) {
			return "FXML file not found. Check if the path '/gui/GameScene.fxml' is correct.";
		}

		// Handle controller initialization issues
		if (cause instanceof InstantiationException) {
			return "Controller class missing or invalid. Check if CtrlerGameBoard exists in the controller package.";
		}

		// Handle invalid FXML markup
		if (cause instanceof javafx.fxml.LoadException) {
			return "Invalid FXML markup. Check for typos in MainMenu.fxml, especially in fx:controller or fx:id.";
		}

		// Generic error with details
		return String.format("%s [%s]", e.getMessage(), e.getClass().getSimpleName());
	}
}
