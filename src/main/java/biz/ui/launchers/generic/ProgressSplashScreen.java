package biz.ui.launchers.generic;

import java.io.InputStream;

import biz.ui.features.InformedProgressBar;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public abstract class ProgressSplashScreen extends SplashScreen{
	
	private InformedProgressBar bar;
	
	public ProgressSplashScreen() {
		super();
		bar = new InformedProgressBar();
		getVBox().getChildren().addAll(bar);
		setSpacing(40);
	}

	@Override
	protected abstract InputStream getImageLoc();
		
	
	/**
	 * this progress value should be given in values <= 1. A value that is >= 1 is 100%
	 * @param progress
	 */
	public void updateProgress(double progress){
		bar.updateProgress(progress);
	}
	
	public void updateProgress(double progress, String progressMessage){
		bar.updateProgress(progress, progressMessage);
	}

	/**
	 * @return the bar
	 */
	public ProgressBar getBar() {
		return bar.getBar();
	}

	/**
	 * @return the progressMessage
	 */
	public Label getProgressMessage() {
		return bar.getProgressMessage();
	}
	
	
	
	
	

}
