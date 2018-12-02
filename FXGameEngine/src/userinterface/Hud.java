package userinterface;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Hud {
	
	private final double MAXGOODEVIL = 100;
	private final double MAXHEALTH = 100;
	private double evil = 10;
	
	
	public Hud() {
		
	}
	
	public void loadHud() {
		
	}
	
	public void updateHud() {
		
	}
	
	public void renderHud(GraphicsContext gc) {
		//Good evil meter
		gc.setFill(Color.DARKGRAY);
		gc.fillRect(200, 20, 200, 30);
		gc.strokeText("Evil", 201, 45);
		gc.setFill(Color.DARKRED);
		gc.fillRect(300, 20, 10, 30);
		gc.strokeText("Good", 366,45);
	}

}
