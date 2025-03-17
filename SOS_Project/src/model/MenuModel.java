package model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MenuModel {
  /** GUI Context for Buttons - creates single source for all game modes moving forward */
  public static final ObservableList<String> GAME_MODES =
      FXCollections.observableArrayList("Simple Game", "General Game");

  /** GUI Context for Buttons - creates single source for all opponent modes moving forward */
  public static final ObservableList<String> OPPONENT_TYPES =
      FXCollections.observableArrayList("Human", "Computer");

  // Custom Methods

  /** Combined single validation method */
  public List<String> inputValidation(List<String> invalidFields, String field, Object input) {
    switch (field) {
      case "gameMode":
        if (!validateChoiceBox(input.toString())) {
          invalidFields.add(field);
        }
        break;
      case "boardSize":
        if (!validateBoardSize(input.toString())) {
          invalidFields.add(field);
        }
        break;
      case "opponentType":
        if (validateChoiceBox(input.toString())) {
          invalidFields.add(field);
        }
        break;
      default:
    }
    return invalidFields;
  }

  /**
   * Validation of Board Size
   *
   * @param String input
   * @return Either 3 or parsed value
   */
  public boolean validateBoardSize(String input) {
    try {
      int parsed = Integer.parseInt(input);
      return parsed > 2;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Validation of Choice box fields
   *
   * @param String input
   * @return True or False
   */
  public boolean validateChoiceBox(String input) {
    if (input == null || input == "") {
      return false;
    } else {
      return true;
    }
  }
}
