package pong.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import pong.elements.Player;
import pong.game.Game;
import pong.input.KeyManager;

public class GameState implements States {
	
	private static Player A, B;
	private Rectangle ball = new Rectangle((Game.width/2-5), (Game.height/2-5), 15, 15);
	private static int xVel=4, yVel=4;
	private Font fonteScore = new Font("Dialog", Font.BOLD, 32);
	
	@Override
	public void init() {
		A = new Player(5,(Game.height - 80)/2, 1);
		B = new Player(775, (Game.height - 80)/2, 2);
		start();
	}
	
	@Override
	public void update() {
		ball.x += xVel;
		ball.y += yVel;
		
		checkKeyPressed(2);
		
		limits();
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.width, Game.height);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(Game.width/2 -5, 0, 10, Game.height);
		g.fillRoundRect(0, 0, Game.width, 80, 15, 15);
		
		g.setColor(Color.BLACK);
		g.setFont(fonteScore);
		g.drawString(Integer.toString(A.getScore()), 20, 40 + g.getFontMetrics(fonteScore).getHeight()/2);
		g.drawString(Integer.toString(B.getScore()), 800 - g.getFontMetrics().stringWidth(Integer.toString(B.getScore()))-20, 40 + g.getFontMetrics(fonteScore).getHeight()/2);
		

		
		g.setColor(Color.GREEN);
		g.fillRoundRect(ball.x, ball.y, ball.width, ball.height, 15, 15);
		
		g.setColor(Color.WHITE);
		g.fillRect(A.x, A.y, A.width, A.height);
		g.fillRect(B.x, B.y, B.width, B.height);
				
	}
	
	@Override
	public void checkKeyPressed(int cod) {
		
		if(KeyManager.w)
			A.move(1);
		if(KeyManager.s)
			A.move(0);
		if(KeyManager.up)
			B.move(1);
		if(KeyManager.down)
			B.move(0);
		
		if(KeyManager.speed && xVel<0)
			xVel = -10;
		else if(!KeyManager.speed && xVel<0)
			xVel = -4;
		if(KeyManager.esc)
			StateManager.setState(StateManager.MENU);
	}
	
	public void start() {
		ball.x = (Game.width/2-5);
		ball.y = (Game.height/2-5);
		
		Random r = new Random();
		xVel = (r.nextInt(2)==0) ? 4 : -4;
		yVel = (r.nextInt(2)==0) ? 4 : -4;
	}

	private void limits() {
		if(ball.x < 0) {
			start();
			B.incScore();
		}if(ball.x > (Game.width-5)) {
			start();
			A.incScore();
		}else if(ball.y < 80) {
			yVel = 4;
		}else if(ball.y > (Game.height - 15)){
			yVel = -4;
		}else if(A.intersects(ball)){
			xVel = 4;
		}else if(B.intersects(ball)) {
			xVel = -4;
		}
	}
	
	/*Métodos criados para teste*/
	public int getPlayerYPosition(int player) {
		if(player == 0) {
			return A.y;
		} else {
			return B.y;
		}
	}
}
