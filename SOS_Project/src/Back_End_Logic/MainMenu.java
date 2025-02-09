package Back_End_Logic;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.*;

public class MainMenu {
	/**
	 *  Descriptive enums for Radio Buttons
	 */
	public enum Option { OPTION1, OPTION2 }
	
	// State Management properties
	private ObjectProperty<Option> selectedOptionA =
			new SimpleObjectProperty<>(Option.OPTION1);
	private IntegerProperty optionB = new SimpleIntegerProperty(3);
	private ObjectProperty<Option> selectedOptionC =
			new SimpleObjectProperty<>(Option.OPTION1);
	
	/**
	 * Unit Testing Specific Function for calling OptionB value
	 * @return Option B Value
	 */
	public int getOptionB() {
		return optionB.get();
	}
	
	/**
	 *  Validation of Board Size
	 * @param	String input
	 * @return	Either 2 or parsed value
	 */
	public void validateOptionB(String input) {
		try {
			int parsed = Integer.parseInt(input);
			optionB.set(parsed > 2 ? parsed : 2);
		} catch (NumberFormatException e) {
			optionB.set(2);
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
