package pong.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import pong.game.Game;

public class HelpState implements States{

	private Font fonteTitle = new Font("Dialog", Font.BOLD, 48);
	private Font fonteInstr = new Font("Dialog", Font.ITALIC, 24);
	private String title = "Instrucoes de Jogo";
	
	private String[] instrA = {"Jogador A","W: move para cima","S: move para baixo"};
	private String[] instrB = {"Jogador B","Seta cima: move para cima","Seta baixo: move para baixo"};
	private String tecla = "Pressione qualquer tecla para voltar";
	
	
	@Override
	public void init() {
	}

	@Override
	public void update() {		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.width, Game.height);
		
		g.setColor(Color.WHITE);
		g.setFont(fonteTitle);
		g.drawString(title, (Game.width/2) - g.getFontMetrics().stringWidth(title)/2, Game.height * 1/4);
		
		
		for(int i=0; i<instrA.length; i++) {
			g.setFont(fonteInstr);
			if(i==0)
				g.drawString(instrA[i], Game.width*1/4 - (g.getFontMetrics().stringWidth(instrA[i])/2), Game.height * 1/2);
			else
				g.drawString(instrA[i], (Game.width*1/4) - (g.getFontMetrics().stringWidth(instrA[i])/2), Game.height * 1/2 + (i * (g.getFontMetrics(fonteInstr).getHeight() + 5)));
		}
		
		for(int i=0; i<instrA.length; i++) {
			g.setFont(fonteInstr);
			if(i==0)
				g.drawString(instrB[i], Game.width*3/4 - (g.getFontMetrics().stringWidth(instrB[i])/2), Game.height * 1/2);
			else
				g.drawString(instrB[i], (Game.width * 3/4) - (g.getFontMetrics().stringWidth(instrB[i])/2), Game.height * 1/2 + (i * (g.getFontMetrics(fonteInstr).getHeight() + 5)));
		}
		
		g.drawString(tecla, Game.width/2 - (g.getFontMetrics().stringWidth(tecla)/2), Game.height * 7/8);

		
		
		
	}

	@Override
	public void checkKeyPressed(int cod) {
		StateManager.setState(StateManager.MENU);
	}
	

}
