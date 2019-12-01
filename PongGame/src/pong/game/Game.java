package pong.game;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import pong.input.KeyManager;
import pong.states.StateManager;
import pong.states.States;
import pong.view.Tela;

public class Game implements Runnable{

	
	public static final int width = 800, height = 500;
	private Thread t;
	private static boolean running = false;
	private Tela tela;
	
	private StateManager sm;
	private KeyManager km;
	
	public Game() {
		tela = new Tela("Pong Game by Arthur Bockmann Grossi" ,width, height);
		
		sm = new StateManager();
		km = new KeyManager();
		tela.setKeyListener(km);
		StateManager.setState(StateManager.MENU);
	}
	
	
	@Override
	public void run() {
		init();
		
		int FPS = 60;
		double timePerTick = 1000000000/FPS;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
			
			
			if(delta >=1) {
				update();
				render();
				delta--;
			}
		}
		stop();
		
	}
	
	private void init() {}
	
	private void update() {
		sm.update();
		km.update();
	}
	
	private void render() {
		BufferStrategy bs = tela.getBufferStrategy();
		if(bs == null) {
			tela.createBufferStrategy();
			bs = tela.getBufferStrategy();
		}
		
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		sm.render(g);
		
		g.dispose();
		bs.show();
		Toolkit.getDefaultToolkit().sync();
		
	}

	public synchronized void start() {
		if(t!=null) return;

		t = new Thread(this);
		Game.running = true;
		t.start();
	}
	
	public synchronized void stop() {
		if(t == null) return;
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			Game.running = false;
		}
		
	}

	public static void stopGame(int code) {
		Game.running = false;
		System.exit(code);
	}
	
	//Método criado para testes de software
	public States GetCurrentState() {
		return StateManager.getState();
	}


	public boolean IsRunning() {
		// TODO Auto-generated method stub
		return Game.running;
	}
}
