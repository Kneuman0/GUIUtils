package biz.ui.launchers.generic;

import java.net.URL;

import biz.ui.controller.utils.IPopUpSaveController;
import javafx.scene.Parent;
import javafx.stage.Stage;

public abstract class SaveableAppLauncher <Controller extends IPopUpSaveController> extends AppLauncher<Controller>{

	/**
	 * Override this method and return the relative path to fxml file.
	 * for example:
	 * return "/resources/someFXMLfile.fxml"
	 * @param relPathToController
	 */
	public abstract String getPathtoFXML();
	
	/**
	 * return the title of the stage for the main application
	 * @return
	 */
	public abstract String getStageTitle();
	
	public abstract void init();
	
	@Override
	public void start(Stage stage) {
		PopupLauncher<Controller> mainWindow = new PopupLauncher<Controller>
		(stage, getStageTitle(), getClass().getResource(getPathtoFXML()));
	
		mainWindow.getStage().setResizable(true);
			
		mainWindow.show();
		IPopUpSaveController saveCon = (IPopUpSaveController)mainWindow.getController();
		stage.getScene().getWindow().setOnCloseRequest(saveCon.getOnCloseRequestListener());
	}
	

}
