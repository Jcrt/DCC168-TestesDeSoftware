package pong.elements;

import java.awt.Rectangle;

import pong.game.Game;

public class Player extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int side, vel=5;
	private static final int offset = 5;
	private int score=0 ;
	
	
	public Player(int posX, int posY, int side) {
		super(posX, posY, 20, 70);
		
		this.score = 0;
				
		if(side>0 && side<3)
			this.side = side;	
	}
		
	private void setYPosition(int posY) {
		if(posY >= (80 + offset) && posY <= Game.height - (this.height + offset))
			this.y = posY;
	}
	
	public void move(int l) {
		if(l == 0) {
			this.setYPosition(this.y+vel);
		}else if(l == 1){
			this.setYPosition(this.y-vel);
		}
	}

	public int getSide() {
		return side;
	}
		
	public void incScore() {
		this.score++;
	}
	
	public int getScore() {
		return this.score;
	}
	
	

}
