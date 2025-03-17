package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.GameParams;
import model.MenuModel;

// Focus should be on communication transport between MainMenuModel and MainMenuView
public class CtrlerMainMenu {
  // Fields
  @FXML private ChoiceBox<String> cbMode;
  @FXML private TextField txtBoardSize;
  @FXML private ChoiceBox<String> cbOp;
  @FXML private Button btnStart;
  @FXML private Label errorLabel;

  private MenuModel model;
  private InputFields fields;
  private Validator validator;

  // Getters
  /**
   * @return the cbMode as a string
   */
  public String getCBMode() {
    return cbMode.getValue();
  }

  /**
   * @return the txtBoardSize as a string
   */
  public String getTxtBoardSize() {
    return txtBoardSize.getText();
  }

  /**
   * @return the cbOpponent as a string
   */
  public String getCBOpponent() {
    return cbOp.getValue();
  }

  // Custom Methods
  /** Initial function to commence Main Menu building and components */
  public void initialize() {
    cbMode.getItems().addAll(model.GAME_MODES);
    // cbOpponent.getItems().addAll(model.OPPONENT_TYPES);

    fields = new InputFields();
    validator = new Validator(model);
  }

  /**
   * Passes all relevant fields to their appropriate designations, quickly catching errors before
   * assessing data validity
   *
   * @return GameParams(boardSize, gameMode, "Human") or Error Message
   */
  @FXML
  private void validateSettings() {

    fields.addField("gameMode", getCBMode());
    fields.addField("boardSize", getTxtBoardSize());

    List<String> invalidFields = validator.input(fields.getAllFields());

    errorLabel.setVisible(false);
    // If empty, all fields are valid and accepted
    if (!invalidFields.isEmpty()) {
      showError(
          "ERROR: The following feilds contained invalid information: "
              + String.join(", ", invalidFields));
      return;
    }

    int boardSize = (Integer) fields.getField("boardSize");
    String gameMode = (String) fields.getField("gameMode");

    App.startGame(new GameParams(boardSize, gameMode, "Human"));
  }

  /**
   * Small method to display any error message
   * 
   * @param message
   */
  private void showError(String message) {
    errorLabel.setText(message);
    errorLabel.setTextFill(Color.RED);
    errorLabel.setVisible(true);
  }

  /** Small method to clear all fields */
  public void reset() {
    txtBoardSize.clear();
    cbMode.setValue(null);
    errorLabel.setVisible(false);
  }

  // Inner Classes
  private class InputFields {
    private Map<String, Object> fields = new HashMap<>();

    public void addField(String fieldName, Object value) {
      fields.put(fieldName, value);
    }

    public Object getField(String fieldName) {
      return fields.get(fieldName);
    }

    public Map<String, Object> getAllFields() {
      return fields;
    }
  }

  private class Validator {
    private MenuModel model;

    public Validator(MenuModel model) {
      this.model = model;
    }

    public List<String> input(Map<String, Object> inputFields) {
      List<String> invalidFields = new ArrayList<>();

      // Checks field name, then executes appropriate validation
      inputFields.forEach(
          (fieldName, value) -> {
            model.inputValidation(invalidFields, fieldName, value);
          });
      return invalidFields;
    }
  }
}
