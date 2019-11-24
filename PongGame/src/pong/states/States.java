package pong.states;

import java.awt.Graphics;

public interface States {
	
	public static final int downArrow = 40, rightArrow = 39, upArrow = 38, leftArrow = 37; 

	void init();
	void update();
	void render(Graphics g);
	void checkKeyPressed(int cod);
}
