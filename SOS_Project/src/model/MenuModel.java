package model;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.*;
import javafx.collections.*;

public class MenuModel {
	/**
	 *  GUI Context for Buttons - creates single source for all game modes moving forward
	 */
	public static final ObservableList<String> GAME_MODES =
		FXCollections.observableArrayList("Simple Game", "General Game");
	
	/**
	 *  GUI Context for Buttons - creates single source for all opponent modes moving forward
	 */
	public static final ObservableList<String> OPPONENT_TYPES =
		FXCollections.observableArrayList("Human", "Computer");
	
	/**
	 *  Generic enum for Choice Boxes & Radio Buttons
	 */
	public enum Option { OPTION1, OPTION2 }
	
	// State Management properties
	private ObjectProperty<Option> selectedOptionA =
			new SimpleObjectProperty<>(Option.OPTION1);
	private IntegerProperty optionB = new SimpleIntegerProperty(3);
	private ObjectProperty<Option> selectedOptionC =
			new SimpleObjectProperty<>(Option.OPTION1);
	
	// Setters and Getters
	/**
	 * Unit Testing Specific Function for calling OptionB value
	 * @return Option B Value
	 */
	public int getOptionB() {
		return optionB.get();
	}
	
	// Custom Methods
	/**
	 * Validation of Game Mode Selection
	 */
	
	/**
	 *  Validation of Board Size
	 * @param	String input
	 * @return	Either 3 or parsed value
	 */
	public boolean validateBoardSize(String input) {
		try {
			int parsed = Integer.parseInt(input);
			return parsed > 2;			
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
