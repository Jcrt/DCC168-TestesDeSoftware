package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.AWTException;
import java.awt.Robot;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import com.sun.glass.events.KeyEvent;
import pong.game.Game;
import pong.states.GameState;

public class FunctionalTest{
	
	protected static final int THREAD_SLEEP_TIME = 2000;
	protected static Game _game = new Game();
	protected Robot _robot;
	
	protected static void Run() {
		if(!_game.IsRunning()) {
			_game.start();
		}
	}
	
	protected void GoToStart() {
		try {
			if(_game.IsRunning()) {
				_robot.keyPress(KeyEvent.VK_ESCAPE);
				Thread.sleep(500);
				_robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(500);
				_robot.keyPress(KeyEvent.VK_ESCAPE);
				Thread.sleep(500);
				_robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(500);
				_robot.keyPress(KeyEvent.VK_UP);
				_robot.keyRelease(KeyEvent.VK_UP);
				Thread.sleep(500);
				_robot.keyPress(KeyEvent.VK_UP);
				_robot.keyRelease(KeyEvent.VK_UP);
				Thread.sleep(500);
			} else {
				Run();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FunctionalTest() {
		try {
			_robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void States_V1_V2() {
		
		String executionOutput = "";
		String expectedOutput = "";
		
		try	{
			//V1, V2
			GoToStart();
			expectedOutput = "pong.states.HelpState";
			
			_robot.keyPress(KeyEvent.VK_DOWN);
			_robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(THREAD_SLEEP_TIME);

			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			executionOutput = _game.GetCurrentState().getClass().getName();
			assertEquals(expectedOutput, executionOutput);
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void States_V3() {
		String executionOutput = "";
		String expectedOutput = "";
		
		try	{
			GoToStart();
			expectedOutput = "pong.states.FPSState";
			
			_robot.keyPress(KeyEvent.VK_F);
			_robot.keyRelease(KeyEvent.VK_F);
			Thread.sleep(THREAD_SLEEP_TIME);

			executionOutput = _game.GetCurrentState().getClass().getName();
			assertEquals(expectedOutput, executionOutput);
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void States_V5() {
		String executionOutput = "";
		String expectedOutput = "";
		
		try	{
			GoToStart();
			expectedOutput = "pong.states.MenuState";
			
			_robot.keyPress(KeyEvent.VK_DOWN);
			_robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_ESCAPE);
			_robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			executionOutput = _game.GetCurrentState().getClass().getName();
			assertEquals(expectedOutput, executionOutput);
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void States_V11() {
		String executionOutput = "";
		String expectedOutput = "";
		
		try	{
			GoToStart();
			expectedOutput = "pong.states.MenuState";
			
			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(THREAD_SLEEP_TIME);
			_robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			executionOutput = _game.GetCurrentState().getClass().getName();
			assertEquals(expectedOutput, executionOutput);
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void States_I1_I2_I3_I4_I5() {
		String executionOutput = "";
		String expectedOutput = "";
		
		try	{
			GoToStart();
			expectedOutput = "pong.states.MenuState";
			
			_robot.keyPress(KeyEvent.VK_0);
			_robot.keyRelease(KeyEvent.VK_0);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_A);
			_robot.keyRelease(KeyEvent.VK_A);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_Z);
			_robot.keyRelease(KeyEvent.VK_Z);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_RIGHT);
			_robot.keyRelease(KeyEvent.VK_RIGHT);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_LEFT);
			_robot.keyRelease(KeyEvent.VK_LEFT);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			executionOutput = _game.GetCurrentState().getClass().getName();
			assertEquals(expectedOutput, executionOutput);
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void States_I6() {
		String executionOutput = "";
		String expectedOutput = "";
		
		try	{
			GoToStart();
			expectedOutput = "pong.states.HelpState";
			
			_robot.keyPress(KeyEvent.VK_DOWN);
			_robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(THREAD_SLEEP_TIME);

			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			executionOutput = _game.GetCurrentState().getClass().getName();
			assertEquals(expectedOutput, executionOutput);
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void Behaviour_Cover_V6_V8() {
		
		try {
			GoToStart();
			
			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			GameState gamestate = (GameState)_game.GetCurrentState();
			int oldYPosLeft = gamestate.getPlayerYPosition(0);
			int oldYPosRight = gamestate.getPlayerYPosition(1);
			
			_robot.keyPress(KeyEvent.VK_W);
			Thread.sleep(THREAD_SLEEP_TIME);
			_robot.keyPress(KeyEvent.VK_UP);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyRelease(KeyEvent.VK_UP);
			_robot.keyRelease(KeyEvent.VK_W);
			Thread.sleep(THREAD_SLEEP_TIME);
						
			int newYPosLeft = gamestate.getPlayerYPosition(0);
			int newYPosRight = gamestate.getPlayerYPosition(1);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			assertTrue(oldYPosLeft > newYPosLeft);
			assertTrue(oldYPosRight > newYPosRight);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Behaviour_Cover_V7_V9() {
		
		try {
			GoToStart();
			
			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			GameState gamestate = (GameState)_game.GetCurrentState();
			int oldYPosLeft = gamestate.getPlayerYPosition(0);
			int oldYPosRight = gamestate.getPlayerYPosition(1);
			
			_robot.keyPress(KeyEvent.VK_S);
			_robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyRelease(KeyEvent.VK_S);
			_robot.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(THREAD_SLEEP_TIME);
						
			int newYPosLeft = gamestate.getPlayerYPosition(0);
			int newYPosRight = gamestate.getPlayerYPosition(1);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			assertTrue(oldYPosLeft < newYPosLeft);
			assertTrue(oldYPosRight < newYPosRight);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Behaviour_Cover_V11() {
		
		try {
			GoToStart();
			
			String executionOutput = "";
			String expectedOutput = "pong.states.MenuState";
			
			_robot.keyPress(KeyEvent.VK_ENTER);
			_robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			_robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(THREAD_SLEEP_TIME);
			
			executionOutput = _game.GetCurrentState().getClass().getName();
			assertEquals(expectedOutput, executionOutput);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void KeysGreaterThan255() throws InterruptedException {
		GoToStart();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			_robot.keyPress(KeyEvent.VK_LEFT_PARENTHESIS);
			Thread.sleep(THREAD_SLEEP_TIME);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			_robot.keyRelease(KeyEvent.VK_LEFT_PARENTHESIS);
			Thread.sleep(THREAD_SLEEP_TIME);
		});
	}
}
