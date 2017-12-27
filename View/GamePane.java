package test4.View;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import test4.Model.FiveChess;
import test4.Model.Piesies4;

public class GamePane  extends Pane{
	private static Canvas canvas = new Canvas(600,600);
	private static GraphicsContext gc;
	private static FiveChess board;
	private Text text = new Text(50,50,"");
	private String currentColor = "white";
	private String winner = null;
	public GamePane(){
		board = FiveChess.getInstance();
		gc = canvas.getGraphicsContext2D();
		draw();
		this.getChildren().add(canvas);
		canvas.setOnMouseClicked(e->{
			if(board.getWinner()==null) {
				int x =(int) (e.getSceneX() - board.getStartX())/board.getWidth();
				int y =(int) (e.getSceneY() - board.getStartY())/board.getWidth();
				add(x,y);
			}
		});
	}
	public void add(int x, int y) {
			if(x<board.getNumber()+1&&y<board.getNumber()+1&&x>=0&&y>=0) {
				board.addPiesies(x, y, currentColor);
				draw();
				if(board.isWin(x, y)) {
					text.setText(board.getWinner()+"方赢了");
					showResult();
				}
				currentColor = currentColor.equals("white") ? "black":"white";
		}
	}
	public static void clear() {
		gc.clearRect(0, 0,canvas.getWidth(), canvas.getHeight());
		gc.setFill(Color.WHEAT);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
		gc.setStroke(Color.BLACK);
	}
	public static void draw () {
		board=FiveChess.getInstance();
		clear();
		double x,y,len;
		int number = board.getNumber();
		x=board.getStartX();
		y=board.getStartY();
		len=board.getWidth();
		for(int i=0;i<number;i++) 
			for(int j= 0;j<number;j++) {
				gc.strokeRect(x+len*i+len/2, y+len*j+len/2,len, len);
			}
		board.getPiesies().stream().forEach(e->drawPiesies(e,x,y,len));
	}
	public static void drawPiesies(Piesies4 e,double x,double y,double len) {
		String color = e.getColor();
		if(color.equals("white"))
			gc.setFill(Color.WHITE);
		else
			gc.setFill(Color.BLACK);
		gc.fillOval(x+e.getX()*len, y+e.getY()*len,len, len);
	}
	public void showResult() {
		Stage second = new Stage();
		Pane result = new Pane();
		result.getChildren().add(text);
		Scene temp = new Scene(result,300,100);
		second.setTitle("结果");
		second.setScene(temp);
		second.sizeToScene();
		second.show();
	}
	public String getWinner() {
		return winner;
	}
}
