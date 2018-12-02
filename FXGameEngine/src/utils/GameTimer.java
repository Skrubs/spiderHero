package utils;

import game.Game;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameTimer extends AnimationTimer {
	
	private long startTime = System.nanoTime();
	private static double timer = 0;
	private GraphicsContext gc;
	private Game game;
	
	public GameTimer(GraphicsContext gc) {
		this.gc = gc;
		game = new Game();
		game.init();
	}
	
	@Override
	public void handle(long now) {
		timer = (now - startTime)/1000000000.0;
		game.udpate(timer);
		game.render(gc);
	}
	
	public static double getTimer() {
		return timer;
	}

}
