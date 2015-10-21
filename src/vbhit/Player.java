package vbhit;

import java.util.ArrayList;

public class Player {
	private Paddle pad;
	private Score score;
	private ArrayList item;
	private char moveupright;
	private char movedownleft;
	private char keymovingflag;//-1 for move to the left or down, 1 for move to the right or move up, 0 is nothing
	private char holdballflag;//1 for hold the ball, 0 is normal
	public Player(){
		
	}
	public Paddle getPad() {
		return pad;
	}
	public void setPad(Paddle pad) {
		this.pad = pad;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public ArrayList getItem() {
		return item;
	}
	public void setItem(ArrayList item) {
		this.item = item;
	}
	public char getMoveupright() {
		return moveupright;
	}
	public void setMoveupright(char moveupright) {
		this.moveupright = moveupright;
	}
	public char getMovedownleft() {
		return movedownleft;
	}
	public void setMovedownleft(char movedownleft) {
		this.movedownleft = movedownleft;
	}
	public char getKeymovingflag() {
		return keymovingflag;
	}
	public void setKeymovingflag(char keymovingflag) {
		this.keymovingflag = keymovingflag;
	}
	public char getHoldballflag() {
		return holdballflag;
	}
	public void setHoldballflag(char holdballflag) {
		this.holdballflag = holdballflag;
	}
	
}
