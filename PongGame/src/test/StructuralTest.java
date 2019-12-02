package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import javafx.scene.input.KeyCode;
import pong.elements.Player;
import pong.game.Game;
import pong.input.KeyManager;
import pong.states.GameState;

class StructuralTest {
	protected static final int THREAD_SLEEP_TIME = 2000;
	protected static Game _game = new Game();
	
	public StructuralTest() {

	}
	
	@Test
	void RunTest() throws InterruptedException {
		
		_game.run();
		Thread.sleep(THREAD_SLEEP_TIME);
		boolean isRunning1 = _game.IsRunning();
		
		_game.run();
		Thread.sleep(THREAD_SLEEP_TIME);
		boolean isRunning2 = _game.IsRunning();
		
		assertEquals(isRunning1, isRunning2);
		
		_game.stop();
		Thread.sleep(THREAD_SLEEP_TIME);
		boolean isRunning3 = _game.IsRunning();
		
		_game.stop();
		Thread.sleep(THREAD_SLEEP_TIME);
		boolean isRunning4 = _game.IsRunning();
		
		assertEquals(isRunning3, isRunning4);
	}
	
	/* Método não testável, pois ao chamar Game.stopGame() todas
	 * as instancias do jogo param de funcionar, ocasionando o fim da aplicação
	 * 
	@Test
	public void StopGame() throws InterruptedException {
		GoToStart();
		
		_robot.keyPress(KeyEvent.VK_DOWN);
		_robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(THREAD_SLEEP_TIME);
		
		_robot.keyPress(KeyEvent.VK_DOWN);
		_robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(THREAD_SLEEP_TIME);
		
		_robot.keyPress(KeyEvent.VK_ENTER);
		_robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(THREAD_SLEEP_TIME);
	}
	*/
	
	@Test
	public void GameState_GetSide_Test() {
		GameState state = new GameState();
		state.init();
		
		Player p1 = state.GetPlayer(true);
		assertEquals(p1.getSide(), 1);
		
		Player p2 = state.GetPlayer(false);
		assertEquals(p2.getSide(), 2);
	}
	
	/*
	@Test
	public void GameState_CheckKeyManagerSpeed_Test() {
		GameState state = new GameState();
		state.init();
		
		KeyManager m = new KeyManager();
		Button a = new Button("click");
		KeyEvent e = new KeyEvent(a, 1, 20, KeyEvent.VK_END, KeyEvent.VK_END, '$');
		m.keyPressed(e);
		
		state.checkKeyPressed(KeyEvent.VK_END);
		
		assertEquals(-10, state.GetXVel());
	}
	*/
	
	@Test
	public void KeyManager_KeyPressed_KeyReleased() throws AWTException {
		KeyManager m = new KeyManager();
		Button a = new Button("click");
		KeyEvent e = new KeyEvent(a, 1, 20, KeyEvent.VK_DOLLAR, KeyEvent.VK_DOLLAR, '$');
		m.keyPressed(e);
		m.keyReleased(e);
		assertTrue(true);
	}
	
	@Test
	public void PlayerIntersectBall() {
		GameState state = new GameState();
		state.init();
		
		Player A = new Player(5,(Game.height - 80)/2, 1);
		Rectangle ballA = new Rectangle(5, (Game.height - 80)/2, 70, 70);
		state.SetPlayer(A, true);
		state.SetBall(ballA);
		state.CallLimits();
		assertEquals(4, state.GetXVel());
		
		
		Player B = new Player(775, (Game.height - 80)/2, 2);
		Rectangle ballB = new Rectangle(775, (Game.height - 80)/2, 70, 70);
		state.SetPlayer(B, false);
		state.SetBall(ballB);
		state.CallLimits();
		assertEquals(-4, state.GetXVel());
		
	}
}
