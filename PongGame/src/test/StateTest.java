package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.jupiter.api.Test;

import com.sun.glass.events.KeyEvent;

import pong.game.Game;

class StateTest {

	@Test
	void States_Cover_V1_V2() throws InterruptedException {
		String executionOutput = "";
		String expectedOutput = "pong.states.HelpState";
		
		try {
			Game game = new Game();
			game.start();
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			
			Thread.sleep(1000);
			
			executionOutput = game.GetCurrentState().getClass().getName();
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedOutput, executionOutput);
	}
	
	@Test
	void States_Cover_V3() throws InterruptedException {
		String executionOutput = "";
		String expectedOutput = "pong.states.FPSState";
		
		try {
			Game game = new Game();
			game.start();
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_F);
			Thread.sleep(1000);
			executionOutput = game.GetCurrentState().getClass().getName();
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		
		assertEquals(expectedOutput, executionOutput);
	}
	
	@Test
	void States_Cover_I1_I2_I3_I4_I5() throws InterruptedException {
		String executionOutput = "";
		String expectedOutput = "pong.states.MenuState";
		
		try {
			Game game = new Game();
			game.start();
			
			Robot r = new Robot();
			
			r.keyPress(KeyEvent.VK_0);
			
			r.keyPress(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_Z);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			
			Thread.sleep(1000);
			executionOutput = game.GetCurrentState().getClass().getName();
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedOutput, executionOutput);
	}
	
	@Test
	void States_Cover_V5() throws InterruptedException {
		String executionOutput = "";
		String expectedOutput = "pong.states.MenuState";
		
		try {
			Game game = new Game();
			game.start();
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			
			executionOutput = game.GetCurrentState().getClass().getName();
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedOutput, executionOutput);
	}
	
	@Test
	void States_Cover_I6() throws InterruptedException {
		String executionOutput = "";
		String expectedOutput = "pong.states.HelpState";
		
		try {
			Game game = new Game();
			game.start();
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(1000);
			
			executionOutput = game.GetCurrentState().getClass().getName();
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedOutput, executionOutput);
	}
	
	@Test
	void States_Cover_V11() throws InterruptedException {
		String executionOutput = "";
		String expectedOutput = "pong.states.MenuState";
		
		try {
			Game game = new Game();
			game.start();
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(1000);
			
			executionOutput = game.GetCurrentState().getClass().getName();
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedOutput, executionOutput);
	}
}
