package util;

import java.io.IOException;
import java.util.function.Supplier;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwap {

	/**
	 * Performs a scene transition with full MVC initialization
	 * 
	 * @param stage                 Current stage (from any node:
	 *                              node.getScene().getWindow())
	 * @param fxmlPath              Path to FXML file ("/gui/SomeScene.fxml")
	 * @param viewClass             View class type (MenuView.class)
	 * @param modelClass            Model class type (MenuModel.class)
	 * @param controllerInitializer Lambda for controller setup
	 * @throws IOException
	 */
	public static <V, M> void sceneSwap(
			Stage stage,
			String fxmlPath,
			Class<V> viewClass,
			Class<M> modelClass,
			Controller<V, M> controller) throws IOException {

		if (stage.getScene() != null) {
			stage.setScene(null);
			System.gc();
		}

		FXMLLoader loader = new FXMLLoader(SceneSwap.class.getResource(fxmlPath));
		Parent root = loader.load();

		V view = loader.getController();
		M model = null;

		try {
			model = modelClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		controller.ctrlerConstructor(view, model);

		stage.setScene(new Scene(root));
		stage.show();
	}

	public static <V, M, C> void sceneSwap(
			Stage stage,
			String fxmlPath,
			Class<V> viewClass,
			Supplier<M> modelSupplier,
			Controller<V, M> controller) throws IOException {
		if (stage.getScene() != null) {
			stage.setScene(null);
			System.gc();
		}

		FXMLLoader loader = new FXMLLoader(SceneSwap.class.getResource(fxmlPath));
		Parent root = loader.load();

		V view = loader.getController();
		M model = modelSupplier.get();

		controller.ctrlerConstructor(view, model);

		stage.setScene(new Scene(root));
		stage.show();
	}
	
	@FunctionalInterface
	public interface Controller<V, M> {
		void ctrlerConstructor(V view, M model);
	}
}
