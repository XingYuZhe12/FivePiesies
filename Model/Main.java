package test4.Model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import test4.View.ControlPane;
import test4.View.GamePane;

public class Main extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		FiveChess board = new FiveChess();
		ControlPane control = new ControlPane();
		GamePane view = new GamePane();
		BorderPane pane = new BorderPane();
		Scene scene = new Scene(pane);
		pane.setCenter(view);
		pane.setRight(control);
		arg0.setScene(scene);
		arg0.setTitle("Îå×ÓÆå");
		arg0.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
