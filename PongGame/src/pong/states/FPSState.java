package pong.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pong.game.Game;

public class FPSState implements States {
	private long now, lastTime = System.nanoTime();
	private static int tick=0;
	private static double timer=0;
	private int t;
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		now = System.nanoTime();
		timer += now - lastTime;
		lastTime = now;
		
		tick++;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.width, Game.height);
		
		if(timer >= 1000000000) {
			t = tick;
			tick = 0;
			timer = 0;
						
		}
		
		g.setColor(Color.WHITE);
		Font font = new Font("Serif", Font.PLAIN, 14);
		String fps = "FPS: " + t;
		
		g.setFont(font);
		g.drawString(fps, g.getFontMetrics().stringWidth(fps), g.getFontMetrics(font).getHeight());

	}

	@Override
	public void checkKeyPressed(int cod) {
		StateManager.setState(StateManager.MENU);
	}

}
