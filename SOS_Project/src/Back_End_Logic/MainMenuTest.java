package Back_End_Logic;
import static org.junit.jupiter.api.Assertions.*;

//import Back_End_Logic.MainMenu;


import org.junit.jupiter.api.Test;

class MainMenuTest {
	@Test
	void gameBoardInvalidTest() {
		assertAll(
				// Invalid Board Size when < 2
				() -> {
					MainMenu testBoard = new MainMenu();
					testBoard.validateOptionB("0");
					assertEquals(2, testBoard.getOptionB());
				},
				// Invalid Board Size when = 2
				() -> {
					MainMenu testBoard = new MainMenu();
					testBoard.validateOptionB("2");
					assertEquals(2, testBoard.getOptionB());
				},
				// Invalid Board Size when not numerical
				() -> {
					MainMenu testBoard = new MainMenu();
					testBoard.validateOptionB("abc");
					assertEquals(2, testBoard.getOptionB());
				}
			);
	}
	
	@Test
	void gameBoardValidTest() {
		// Valid board Size when > 2
		MainMenu testBoard = new MainMenu();
		testBoard.validateOptionB("3");
		
		assertEquals(3, testBoard.getOptionB());
	}		
}

