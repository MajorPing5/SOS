package model;

import java.util.ArrayList;

public class GameModel {
	// Fields
	private ArrayList<GameModel> settings = new ArrayList<>();
	private int boardSize;
	private String gameMode, opponentType;

	// Constructor  - Empty Constructor
	public GameModel() {}

	/**
	 * Overloaded constructor to retrieve all current game settings
	 * @param boardSize Integer value of an item's ID
	 * @param gameMode	String name of selected Game mode
	 * @param opponentType	String name of selected P2 type
	 */
	public GameModel(int boardSize, String gameMode, String opponentType) {
		super();
		this.boardSize = boardSize;
		this.gameMode = gameMode;
		this.opponentType = opponentType;
	}

	// Getters & Setters
	/**
	 * @return the boardSize
	 */
	public int getBoardSize() {
		return boardSize;
	}

	/**
	 * @param boardSize the boardSize to set
	 */
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	/**
	 * @return the gameMode
	 */
	public String getGameMode() {
		return gameMode;
	}

	/**
	 * @param gameMode the gameMode to set
	 */
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	/**
	 * @return the opponentType
	 */
	public String getOpponentType() {
		return opponentType;
	}

	/**
	 * @param opponentType the opponentType to set
	 */
	public void setOpponentType(String opponentType) {
		this.opponentType = opponentType;
	}

	/**
	 * @return the settings
	 */
	public ArrayList<GameModel> getSettings() {
		return settings;
	}

	/**
	 * @param settings the settings to set
	 */
	public void setSettings(ArrayList<GameModel> settings) {
		this.settings = settings;
	}

	// Custom Methods
	/** Adds a list of settings to the ArrayList */
	public void createSettings(GameModel settingsObj) {
		settings.add(settingsObj);
	}

	/** Clears all settings in the ArrayList */
	public void clearSettings() {
		settings.removeAll(settings);
	}
}
