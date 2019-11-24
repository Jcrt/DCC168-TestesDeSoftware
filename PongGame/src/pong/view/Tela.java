package pong.view;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Tela extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JFrame jframe = new JFrame();
	
	private Canvas canvas;
	
	
	public Tela(String title, int width, int height) {
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		canvas.setFocusable(false);
		
		jframe = new JFrame();
		jframe.add(canvas);
		jframe.pack();
		
		jframe.requestFocus();
				
		jframe.setTitle(title);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}		
	
	public BufferStrategy getBufferStrategy() {
		return canvas.getBufferStrategy();
	}
	
	public void createBufferStrategy() {
		canvas.createBufferStrategy(2);
	}
	
	public void setKeyListener(KeyListener kl) {
		jframe.addKeyListener(kl);
	}
}
