package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MenuModelTest {
  private MenuModel model;

  @Test
  void gameBoardInvalidTest() {
    assertAll(
        // Invalid Board Size when < 2
        () -> {
          MenuModel testBoard = new MenuModel();
          assertEquals(false, testBoard.validateBoardSize("0"));
        },
        // Invalid Board Size when = 2
        () -> {
          MenuModel testBoard = new MenuModel();
          assertEquals(false, testBoard.validateBoardSize("2"));
        },
        // Invalid Board Size when not numerical
        () -> {
          MenuModel testBoard = new MenuModel();
          assertEquals(false, testBoard.validateBoardSize("abc"));
        });
  }

  @Test
  void gameBoardValidTest() {
    // Valid board Size when > 2
    MenuModel testBoard = new MenuModel();
    testBoard.validateBoardSize("3");

    assertEquals(true, testBoard.validateBoardSize("3"));
  }
}
