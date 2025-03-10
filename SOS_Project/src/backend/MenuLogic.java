package backend;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.*;
import javafx.collections.*;

public class MenuLogic {
	/**
	 *  Context for GUI Buttons to always pull from - creates single source of truth for all game modes moving forward
	 */
	public static final ObservableList<String> GAME_MODES
		= FXCollections.observableArrayList("Simple Game", "General Game");
	
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
	public void validateOptionB(String input) {
		try {
			int parsed = Integer.parseInt(input);
			
			if (parsed < 3)
				optionB.set(parsed > 2 ? parsed : 3);
			
		} catch (NumberFormatException e) {
			optionB.set(3);
		}
	}
	
	/**
	 * Readiness Check based on Valid Grid Size
	 * @return The Boolean of Board Size > 2
	 */
	public BooleanExpression isReadyToStart() {
		return optionB.greaterThan(2);
	}
}
