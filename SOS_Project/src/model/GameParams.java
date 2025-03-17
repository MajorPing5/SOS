package model;

// Focus shouild be on immutable data carrier ONLY
/** Class responsible for ALL relevant Game Settings and Parameters */
public class GameParams {
  private final int boardSize;
  private final String gameMode, opponentType;

  // Getters & Setters
  /**
   * Getter that retrieves the current Board Size
   *
   * @return boardSize
   */
  public int getBoardSize() {
    return boardSize;
  }

  /**
   * Getter that retrieves the current Game Mode setting
   *
   * @return gameMode
   */
  public String getGameMode() {
    return gameMode;
  }

  /**
   * Getter that retrieves the current Opponent setting
   *
   * @return opponentType
   */
  public String getOpponentType() {
    return opponentType;
  }

  // Custom Methods
  /**
   * Function to retrieve all defined parameters specific for the currently running game
   * 
   * @param boardSize
   * @param gameMode
   * @param opponentType
   */
  public GameParams(int boardSize, String gameMode, String opponentType) {
    super();
    this.boardSize = boardSize;
    this.gameMode = gameMode;
    this.opponentType = opponentType;
  }
}
