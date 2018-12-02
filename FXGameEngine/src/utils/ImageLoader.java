package utils;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

public class ImageLoader {
	
	private static Image bottom_border = new Image("textures/border.png");
	
	public static WritableImage bottomBorder = new WritableImage(bottom_border.getPixelReader(),0,170,2000,230);
	public static WritableImage topBorder = new WritableImage(bottom_border.getPixelReader(),0,400,2000,230);
	public static WritableImage leftBorder = new WritableImage(bottom_border.getPixelReader(),2003,2,230,1998);
	public static WritableImage rightBorder = new WritableImage(bottom_border.getPixelReader(),2570,0,230,2000);
	
	
	
	private static Image webshotSpritesheet = new Image("textures/webshot.png");
	
	public static WritableImage webshot = new WritableImage(webshotSpritesheet.getPixelReader(),0,0,64,64);
	public static WritableImage webshotLanded = new WritableImage(webshotSpritesheet.getPixelReader(),64,0,64,64);
	
	private static Image tileset = new Image("textures/tileset.png");
	
	public static WritableImage grass = new WritableImage(tileset.getPixelReader(),0,0,32,32);
	
	public static Image town = new Image("textures/town.png");
	
	public static Image house_1 = new Image("textures/house1.png");
	
	public static Image missImage = new Image("textures/MissingImage.png");
	
	
	private static Image idle_player = new Image("textures/idleplayer.png");
	
	//idle player up
	public static WritableImage idle_player_up_1 = new WritableImage(idle_player.getPixelReader(),0,0,64,64);
	public static WritableImage idle_player_up_2 = new WritableImage(idle_player.getPixelReader(),64,0,64,64);
	public static WritableImage idle_player_up_3 = new WritableImage(idle_player.getPixelReader(),128,0,64,64);
	public static WritableImage idle_player_up_4 = new WritableImage(idle_player.getPixelReader(),192,0,64,64);
	
	//idle player down
	public static WritableImage idle_player_down_1 = new WritableImage(idle_player.getPixelReader(),0,128,64,64);
	public static WritableImage idle_player_down_2 = new WritableImage(idle_player.getPixelReader(),64,128,64,64);
	public static WritableImage idle_player_down_3 = new WritableImage(idle_player.getPixelReader(),128,128,64,64);
	public static WritableImage idle_player_down_4 = new WritableImage(idle_player.getPixelReader(),192,128,64,64);

	//idle player right
	public static WritableImage idle_player_right_1 = new WritableImage(idle_player.getPixelReader(),0,64,64,64);
	public static WritableImage idle_player_right_2 = new WritableImage(idle_player.getPixelReader(),64,64,64,64);
	public static WritableImage idle_player_right_3 = new WritableImage(idle_player.getPixelReader(),128,64,64,64);
	public static WritableImage idle_player_right_4 = new WritableImage(idle_player.getPixelReader(),192,64,64,64);
	
	//idle player left
	public static WritableImage idle_player_left_1 = new WritableImage(idle_player.getPixelReader(),0,192,64,64);
	public static WritableImage idle_player_left_2 = new WritableImage(idle_player.getPixelReader(),64,192,64,64);
	public static WritableImage idle_player_left_3 = new WritableImage(idle_player.getPixelReader(),128,192,64,64);
	public static WritableImage idle_player_left_4 = new WritableImage(idle_player.getPixelReader(),192,192,64,64);
	
}
