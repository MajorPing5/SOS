package controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class CtrlerGameBoard {

    @FXML // fx:id="gameBoard"
    private GridPane gameBoard; // Value injected by FXMLLoader

    @FXML // fx:id="p1radioGroup"
    private ToggleGroup p1radioGroup; // Value injected by FXMLLoader

    @FXML // fx:id="p2RadioGroup"
    private ToggleGroup p2RadioGroup; // Value injected by FXMLLoader

    @FXML // fx:id="player1O"
    private RadioButton player1O; // Value injected by FXMLLoader

    @FXML // fx:id="player1S"
    private RadioButton player1S; // Value injected by FXMLLoader

    @FXML // fx:id="player2O"
    private RadioButton player2O; // Value injected by FXMLLoader

    @FXML // fx:id="player2S"
    private RadioButton player2S; // Value injected by FXMLLoader

}
