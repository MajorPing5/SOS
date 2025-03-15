package model;
import static org.junit.jupiter.api.Assertions.*;

//import Back_End_Logic.MainMenu;


import org.junit.jupiter.api.Test;

class MenuModelTest {
	@Test
	void gameBoardInvalidTest() {
		assertAll(
				// Invalid Board Size when < 2
				() -> {
					MenuModel testBoard = new MenuModel();
					testBoard.validateBoardSize("0");
					assertEquals(2, testBoard.getOptionB());
				},
				// Invalid Board Size when = 2
				() -> {
					MenuModel testBoard = new MenuModel();
					testBoard.validateBoardSize("2");
					assertEquals(2, testBoard.getOptionB());
				},
				// Invalid Board Size when not numerical
				() -> {
					MenuModel testBoard = new MenuModel();
					testBoard.validateBoardSize("abc");
					assertEquals(2, testBoard.getOptionB());
				}
			);
	}
	
	@Test
	void gameBoardValidTest() {
		// Valid board Size when > 2
		MenuModel testBoard = new MenuModel();
		testBoard.validateBoardSize("3");
		
		assertEquals(3, testBoard.getOptionB());
	}		
}