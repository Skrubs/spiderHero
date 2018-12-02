package world;


import java.util.ArrayList;

import entities.Border;
import utils.Id;
import utils.ImageLoader;

public class Map {
	
	
	
	private Border leftBorder;
	private Border topBorder_1;
	private Border topBorder_2;
	private Border rightBorder;
	private Border bottomBorder_1;
	private Border bottomBorder_2;
	private ArrayList<Border> map = new ArrayList<>();
	private ArrayList<Spawnpoint> spawnpoints = new ArrayList<>();
	
	public Map() {
		
		leftBorder = new Border(ImageLoader.leftBorder,-1000,0,Id.border);
		topBorder_1 = new Border(ImageLoader.topBorder,-1000,0,Id.border);
		topBorder_2 = new Border(ImageLoader.topBorder,1000,0,Id.border);
		rightBorder = new Border(ImageLoader.rightBorder,2770,0,Id.border);
		bottomBorder_1 = new Border(ImageLoader.bottomBorder,-1000,1900,Id.border);
		bottomBorder_2 = new Border(ImageLoader.bottomBorder,1000,1900,Id.border);
		map.add(leftBorder);
		map.add(topBorder_1);
		map.add(topBorder_2);
		map.add(rightBorder);
		map.add(bottomBorder_1);
		map.add(bottomBorder_2);
		createSpawnPoints();
		
	}
	
	public void createSpawnPoints() {
		spawnpoints.add(new Spawnpoint(-100,30));
		spawnpoints.add(new Spawnpoint(1800,30));
		spawnpoints.add(new Spawnpoint(1800,1700));
		spawnpoints.add(new Spawnpoint(-500,800));
		spawnpoints.add(new Spawnpoint(500,30));
		spawnpoints.add(new Spawnpoint(1000,100));
		spawnpoints.add(new Spawnpoint(500,1600));
		spawnpoints.add(new Spawnpoint(-800,1600));
		spawnpoints.add(new Spawnpoint(-300,400));
		spawnpoints.add(new Spawnpoint(1600,500));
	}
	
	public ArrayList<Spawnpoint> getSpawnPoints(){
		return spawnpoints;
	}

	public Border getLeftBorder() {
		return leftBorder;
	}

	public void setLeftBorder(Border leftBorder) {
		this.leftBorder = leftBorder;
	}

	public Border getTopBorder_1() {
		return topBorder_1;
	}

	public void setTopBorder_1(Border topBorder_1) {
		this.topBorder_1 = topBorder_1;
	}

	public Border getTopBorder_2() {
		return topBorder_2;
	}

	public void setTopBorder_2(Border topBorder_2) {
		this.topBorder_2 = topBorder_2;
	}

	public Border getRightBorder() {
		return rightBorder;
	}

	public void setRightBorder(Border rightBorder) {
		this.rightBorder = rightBorder;
	}

	public Border getBottomBorder_1() {
		return bottomBorder_1;
	}

	public void setBottomBorder_1(Border bottomBorder_1) {
		this.bottomBorder_1 = bottomBorder_1;
	}

	public Border getBottomBorder_2() {
		return bottomBorder_2;
	}

	public void setBottomBorder_2(Border bottomBorder_2) {
		this.bottomBorder_2 = bottomBorder_2;
	}

	public ArrayList<Border> getMap() {
		return map;
	}

	public void setMap(ArrayList<Border> map) {
		this.map = map;
	}
	
	

}
