package test4.Model;

import java.util.ArrayList;
import java.util.List;

public class FiveChess {
	private List<Piesies4> piesies;
	private int startX = 50;
	private int startY = 50;
	private int width = 30;
	private int number = 16;
	private char[][] board; 
	private static FiveChess instance;
	private String winner = null;
	Piesies4 currentP = null;
	public FiveChess() {
		piesies = new ArrayList<>();
		winner = null;
		board = new char[number+1][number+1];
		for(int i =0;i<number;i++)
			for(int j = 0;j<number;j++)
			board[i][j]=' ';
		instance = this;
	}
	public boolean addPiesies(int x,int y,String color) {
		currentP = new Piesies4(x,y,color);
		if(!piesies.contains(currentP)) {
			piesies.add(currentP);
			board[x][y] = color.equals("white") ? 'w' : 'b';
			return true;
		}
		else
			return false;
		
	}
	public int judgeCondition(char[][] board, int i, int j,char player, int count, int direction) { // �ݹ��ж��˸�������һ�������м�ö����һ�ߵ�����
		if (i > number || j > number || i < 0 || j < 0)
			return count; // ��ֹ����Խ��
		if (board[i][j] == player) {
			count++;
			switch (direction) {
			case 0:
				count = judgeCondition(board, i - 1, j, player, count, direction);
				break;
			case 1:
				count = judgeCondition(board, i - 1, j + 1, player, count, direction);
				break;
			case 2:
				count = judgeCondition(board, i, j + 1, player, count, direction);
				break;
			case 3:
				count = judgeCondition(board, i + 1, j + 1, player, count, direction);
				break;
			case 4:
				count = judgeCondition(board, i + 1, j, player, count, direction);
				break;
			case 5:
				count = judgeCondition(board, i + 1, j - 1, player, count, direction);
				break;
			case 6:
				count = judgeCondition(board, i, j - 1, player, count, direction);
				break;
			case 7:
				count = judgeCondition(board, i - 1, j - 1, player, count, direction);
				break;
			}
			return count;
		} else
			return count;
	}

	public  boolean judgeCondition( int i, int j,char player, int count) { // �ж��������ӷ��Ƿ�ʤ��
		if (judgeCondition(board, i - 1, j, player, count, 0) + judgeCondition(board, i + 1, j, player, count, 4)
				+ 1 >= 5) { // �������������������Ƿ���������
			return true;
		}
		if (judgeCondition(board, i - 1, j + 1, player, count, 1)
				+ judgeCondition(board, i + 1, j - 1, player, count, 5) + 1 >= 5) { // ������������������б���Ƿ���������
			return true;
		}
		if (judgeCondition(board, i, j + 1, player, count, 2) + judgeCondition(board, i, j - 1, player, count, 6)
				+ 1 >= 5) { // �������������������Ƿ���������
			return true;
		}
		if (judgeCondition(board, i + 1, j + 1, player, count, 3)
				+ judgeCondition(board, i - 1, j - 1, player, count, 7) + 1 >= 5) { // ������������������б���Ƿ���������
			return true;
		}
		return false;
	}
	public boolean isWin(int x,int y) {
		if(judgeCondition(x,y,board[x][y],0)) {
			if(board[x][y]=='w')
				winner = "��";
			else
				winner = "��";
			return true;
		}
		return false;
	}
	public List<Piesies4> getPiesies() {
		return piesies;
	}
	public void setPiesies(List<Piesies4> piesies) {
		this.piesies = piesies;
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStartY() {
		return startY;
	}
	public void setStartY(int startY) {
		this.startY = startY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public char[][] getBoard() {
		return board;
	}
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	public static FiveChess getInstance() {
		return instance;
	}
	public static void setInstance(FiveChess instance) {
		FiveChess.instance = instance;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
}
