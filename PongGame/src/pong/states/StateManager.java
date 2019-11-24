package pong.states;

import java.awt.Graphics;

public class StateManager{
	
	private static final int numberStates = 4;
	private static States[] states = new States[numberStates];
	private static int currentState = 0;
	
	public static final int FPS = 0, MENU = 1, GAME = 2, HELP = 3;
		
	public static void setState(int state) {
		currentState = state;
		states[currentState].init();
	}
	
	public static States getState() {
		return states[currentState];
	}
	
	
	public StateManager() {
		states[0] = new FPSState();
		states[1] = new MenuState();
		states[2] = new GameState();
		states[3] = new HelpState();
	}
	
	public void update() {
		states[currentState].update();
	}
	
	public void render(Graphics g) {
		states[currentState].render(g);
	}
}
