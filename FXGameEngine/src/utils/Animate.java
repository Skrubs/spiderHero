package utils;

import javafx.scene.image.Image;

public class Animate {
	
	
	
	public Animate() {
			
	}
	
	
	public static Image animateCharacter(Image[] frames, double duration) {
		int index = (int)((GameTimer.getTimer() % (frames.length * duration))/duration);
		return frames[index];
	}

}
