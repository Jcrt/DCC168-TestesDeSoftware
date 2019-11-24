package pong.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import pong.game.Game;

public class MenuState implements States {

	private Font fontTitle;
	private Font fontOptions;
	private String[] options = {"START", "HELP", "QUIT"};
	private static final String title = "PONG GAME";
	private static int choice = 0;
	private int xVel=1, yVel=1;
	private Rectangle ball = new Rectangle(0, 0, 15, 15);
	
	@Override
	public void init() {
		fontTitle = new Font("Dialog", Font.BOLD, 56);
		fontOptions = new Font("Dialog", Font.PLAIN, 32);
	}

	@Override
	public void update() {
		ball.x+=xVel;
		ball.y+=yVel;
		
		limits();
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.width, Game.height);
		
		
		g.setColor(Color.GREEN);
		g.fillRoundRect(ball.x, ball.y, ball.width, ball.height, 15, 15);
		
		g.setColor(Color.WHITE);
		g.setFont(fontTitle);
		g.drawString(title, Game.width/2 - (g.getFontMetrics().stringWidth(title)/2), Game.height * 1/3);
		
		g.setFont(fontOptions);
		
		for(int i=0; i<options.length; i++) {
			g.setColor(Color.WHITE);
			if(i == choice) {
				g.setColor(Color.RED);
			}
			
			g.drawString(options[i], Game.width/2 - (g.getFontMetrics().stringWidth(options[i])/2), Game.height * 3/5 + (i * (g.getFontMetrics(fontOptions).getHeight()+5)));
		}
	}
	
	private void limits() {
		if(ball.x > (Game.width-15) || ball.x < 0) {
			xVel = xVel * (-1);;
		}
		if(ball.y > (Game.height -15) || ball.y < 0) {
			yVel = yVel * (-1);
		}
		
	}

	private void select() {
		switch(choice) {
		case 0:	
				StateManager.setState(StateManager.GAME);
				break;
		case 1:	
				StateManager.setState(StateManager.HELP);
				break;
		case 2:
				Game.stopGame(0);
				break;
		default:
				break;
		}
		
	}
	
	public void checkKeyPressed(int cod) {
		
		switch(cod) {
		case States.upArrow: 
								if(choice > 0 )
									choice--;
								break;
		case States.leftArrow: 	break;
		case States.rightArrow: break;
		case States.downArrow: 
								if(choice < (options.length-1))
									choice++;
								break;
		case KeyEvent.VK_ENTER:
								select();break;
		case KeyEvent.VK_F:
								StateManager.setState(StateManager.FPS);
								break;
		default:
								break;

		}
	}
}
