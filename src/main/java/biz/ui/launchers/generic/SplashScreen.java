package biz.ui.launchers.generic;

import java.io.InputStream;

import javafx.application.Preloader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SuppressWarnings("restriction")
public abstract class SplashScreen extends Preloader {

	private VBox box;
	private Scene scene;
	
	public SplashScreen() {
		box = new VBox();
		box.setPrefHeight(400);
		box.setPrefWidth(600);
		box.setAlignment(Pos.CENTER);
		scene = new Scene(box);
		ImageView view = null;
		
		if(getImageLoc() != null) view = new ImageView(new Image(getImageLoc()));
		if(view != null) box.getChildren().add(view);
		setBackground(Color.CYAN);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}

	/**
	 * return null if no image is desired, otherwise return inputstream to image
	 * @return
	 */
	protected abstract InputStream getImageLoc();

	/**
	 * gets the VBox containing all nodes in the splashscreen 
	 * @return
	 */
	public VBox getVBox() {
		return box;
	}

	/**
	 * returns the scene in case purging all default settings is desired
	 * @return
	 */
	public Scene getScene() {
		return scene;
	}

	/**
	 * Sets the background a blank color. Override to implement your own background
	 * @param color
	 */
	public void setBackground(Color color) {
		BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(fill);
		box.setBackground(background);
	}
	
	public void setSpacing(double gap){
		box.setSpacing(gap);
	}
	
	public class DisplayLabelThread extends Thread{
		private Label label;
		private String string;
		
		public DisplayLabelThread(Label label, String string){
			this.label = label;
			this.string = string;
		}
		
		@Override
		public void run() {
			label.setText(string);
		}
	}


}
