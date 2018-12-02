package utils;

import java.util.ArrayList;

import entities.Player;
import javafx.scene.Scene;

public class Movement {

	private Player player;
	private Scene scene;
	private ArrayList<String> inputList = new ArrayList<>();
	private String currentKey = "none";

	public Movement(Player player, Scene scene) {
		this.player = player;
		this.scene = scene;
	}

	public void movePlayer() {
		scene.setOnKeyPressed(e -> {
			String code = e.getCode().toString();
			if (!inputList.contains(code)) {
				inputList.add(code);
				currentKey = code.toString();
			}
		});

		scene.setOnKeyReleased(e -> {
			String code = e.getCode().toString();
			if (inputList.contains(code)) {
				inputList.remove(code);
				currentKey = "none";
			}
		});

		if (inputList.contains("W")) {
			player.setVelY(-3);
		}else if(player.getVelY() < 0) {
			player.setVelY(0);
		}
		if (inputList.contains("S")) {
			player.setVelY(3);
		}else if(player.getVelY() > 0) {
			player.setVelY(0);
		}
		if (inputList.contains("D")) {
			player.setVelX(3);
		}else if(player.getVelX() > 0) {
			player.setVelX(0);
		}
		if (inputList.contains("A")) {
			player.setVelX(-3);
		}else if(player.getVelX() < 0) {
			player.setVelX(0);
		}

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public ArrayList<String> getInputList() {
		return inputList;
	}

	public void setInputList(ArrayList<String> inputList) {
		this.inputList = inputList;
	}

	public String getCurrentKey() {
		return currentKey;
	}

	public void setCurrentKey(String currentKey) {
		this.currentKey = currentKey;
	}
	
	

}
