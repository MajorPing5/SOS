package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.GameModel;
import model.MenuModel;
import view.GameView;
import view.MenuView;
import util.SceneSwap;

// Focus should be on communication transport between MainMenuModel and MainMenuView
public class CtrlerMainMenu {
	private MenuView view;
	private MenuModel model;
	private GameModel settings;
	private InputFields fields = new InputFields();
	private Validator validator;

	private int boardSize;
	private String gameMode;
	private String opponentType = "Human"; // Set to human until AI implementation

	//Constructor
	/**
	 * Main Constructor Constructor
	 * 
	 * @param MenuView an instance of the MenuView view
	 * @param MenuModel an instance of the MenuModel model
	 */
	public CtrlerMainMenu(MenuView view, MenuModel model) {
		this.view = view;
		this.model = model;
		this.validator = new Validator(model);

		view.setCBModeOptions(MenuModel.GAME_MODES);

		view.getBtnStart().setOnAction(a-> {
			view.hideError();

			fields.addField("gameMode", view.getCBModeChoice());
			fields.addField("boardSize", view.getTxtBoardSize());
			fields.addField("opponentType", opponentType);

			List<String> invalidFields = validator.input(fields.getAllFields());

			// If empty, all fields are valid and accepted
			if (!invalidFields.isEmpty()) {
				view.showError(
						"ERROR: The following feilds contained invalid information: "
								+ String.join(", ", invalidFields));
				return;
			} else {
				try {
					// Extract validated parameters
					String txtBoardSize = (String) fields.getField("boardSize");
					boardSize = Integer.parseInt(txtBoardSize);
					gameMode = (String) fields.getField("gameMode");
					opponentType = (String) fields.getField("opponentType");
					
					SceneSwap.sceneSwap(
							view.getStage(),
							"/gui/GameScene.fxml",
							GameView.class,
							() -> {
								// Creates main game model
								GameModel gameModel = new GameModel();

								// Creates settings object
								GameModel settings = new GameModel(
										boardSize,
										gameMode,
										opponentType);

								//' Adds settings to model's list
								gameModel.createSettings(settings);

								return gameModel;
							},
							(gameView, gameModel) -> {
								GameModel settings = gameModel.getSettings().get(0);

								new CtrlerGameBoard(gameView, settings);
							}
							);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Custom Methods
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