package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.stage.Screen;
import javafx.stage.Stage;
import utils.GameTimer;


public class Main extends Application {
	
	private static Stage window;
	private static Scene scene;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	public static final double WINDOW_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();
	public static final double WINDOW_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
	private boolean isRunning;
	private String title = "SpiderHero v0.01";
	private static boolean isDebug = false;
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		root = new Group();
		scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		Button debug = new Button("Debug");
		debug.setFocusTraversable(false);
		debug.translateXProperty().set(20);
		debug.translateYProperty().set(20);
		
		debug.setOnAction(e->{
			if(!isDebug) {
				isDebug = true;
				
			}else {
				isDebug = false;
			}
			
			System.out.println(isDebug);
			
		});
		
		root.getChildren().add(debug);
		
		
		
		//initiate Game Timer
		GameTimer gameTimer = new GameTimer(gc);
		
				
		
		isRunning = true;
		
		if(isRunning) {
			window.setScene(scene);
			gameTimer.start();
		}
		
		window.setTitle(title);
		window.sizeToScene();
		window.setMaximized(true);
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getWindow() {
		return window;
	}
	public static Scene getScene() {
		return scene;
	}
	
	public static boolean getIsDebug() {
		return isDebug;
	}
}
