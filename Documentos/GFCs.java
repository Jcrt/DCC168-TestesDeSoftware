public class GameState implements States {
// [...]

/*1*/   private void limits() {
/*1*/       if(ball.x < 0) {
/*2*/           start();
/*2*/           B.incScore();
/*3*/       }if(ball.x > (Game.width-5)) {
/*4*/           start();
/*4*/           A.incScore();
/*5*/       }else if(ball.y < 80) {
/*6*/           yVel = 4;
/*7*/       }else if(ball.y > (Game.height - 15)){
/*8*/           yVel = -4;
/*9*/       }else if(A.intersects(ball)){
/*10*/          xVel = 4;
/*11*/      }else if(B.intersects(ball)) {
/*12*/          xVel = -4;
/*12*/      }
/*13*/  }

// [...]
}


public class Game implements Runnable{
// [...]
	
/*1*/	public void run() {
/*1*/		init();
		
/*1*/ 		int FPS = 60;
/*1*/		double timePerTick = 1000000000/FPS;
/*1*/		double delta = 0;
/*1*/   	long now;
/*1*/		long lastTime = System.nanoTime();
		
/*1*/		while(running) {
/*2*/			now = System.nanoTime();
/*2*/			delta += (now - lastTime)/timePerTick;
/*2*/			lastTime = now;
			
/*3*/			if(delta >=1) {
/*4*/				update();
/*4*/				render();
/*4*/				delta--;
/*4*/			}
/*5*/		}
/*5*/		stop();
/*6*/	}

// [...]
}

public class GameState implements States {
// [...]

/*1*/	public void checkKeyPressed(int cod) {
/*1*/		if(KeyManager.w)
/*2*/			A.move(1);
/*3*/		if(KeyManager.s)
/*4*/			A.move(0);
/*5*/		if(KeyManager.up)
/*6*/			B.move(1);
/*7*/		if(KeyManager.down)
/*8*/			B.move(0);
	
/*9*/		if(KeyManager.speed && xVel<0)
/*10*/			xVel = -10;
/*11*/		else if(!KeyManager.speed && xVel<0)
/*12*/			xVel = -4;
/*13*/		if(KeyManager.esc)
/*14*/			StateManager.setState(StateManager.MENU);
/*15*/	}

// [...]
}
