package test4.View;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import test4.Model.FiveChess;

public class ControlPane extends StackPane{
	FiveChess board;
	Button btReplay = new Button("重新比赛");
	public ControlPane() {
		btReplay.setOnAction(e->{
			board = new FiveChess();
			GamePane.draw();			
		});
		this.getChildren().add(btReplay);
	}
}
