package biz.ui.launchers.generic;

import java.io.IOException;
import java.net.URL;

import biz.ui.controller.utils.IPopupController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class PopupLauncher <Controller extends IPopupController>{
	
	protected Controller controller;
	protected Stage stage;
	
	public PopupLauncher(Stage stage, String title, URL fxmlLocation){
		this.stage = stage;
		FXMLLoader loader = null;
		Parent parent = null;
		try {
			// Reads in the FXML file and initializes the fields in the
			// controller/GUI
			loader = new FXMLLoader(fxmlLocation);
			parent = loader.<Parent> load();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Retrieves the instance of the controller
		this.controller = loader
				.<Controller> getController();
		controller.setStage(this.stage);

		Scene scene = new Scene(parent);

		// window title
		stage.setTitle(title);
		stage.setScene(scene);
	}
	
	public PopupLauncher(String title, URL fxmlLocation){
		this(new Stage(), title, fxmlLocation);		
	}
	
	public PopupLauncher(String title, Parent parent) {
		this.stage = new Stage();
		this.stage.setTitle(title);
		Scene scene = new Scene(parent);
		stage.setScene(scene);
	}
	

	
	public Controller getController(){
		return controller;
	}
	
	public void show(){
		stage.show();
	}
	
	public Stage getStage(){
		return stage;
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
