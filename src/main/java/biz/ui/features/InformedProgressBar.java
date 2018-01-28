package biz.ui.features;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

@SuppressWarnings("restriction")
public class InformedProgressBar extends VBox{
	
	protected ProgressBar bar;
	protected Label progressMessage;
	
	public InformedProgressBar(){
		bar = new ProgressBar();
		bar.setPrefWidth(400);
		progressMessage = new Label();
		setSpacing(2);
		getChildren().addAll(progressMessage, bar);
		setAlignment(Pos.CENTER);
	}

	/**
	 * @return the bar
	 */
	public ProgressBar getBar() {
		return bar;
	}

	/**
	 * @return the progressMessage
	 */
	public Label getProgressMessage() {
		return progressMessage;
	}
	
	/**
	 * this progress value should be given in values <= 1. A value that is >= 1 is 100%
	 * @param progress
	 */
	public void updateProgress(double progress){
		bar.setProgress(progress);
	}
	
	/**
	 * this progress value should be given in values <= 1. A value that is >= 1 is 100%
	 * @param progress
	 */
	public void updateProgress(double progress, String progressMessage){
		this.updateProgress(progress);
		this.progressMessage.setText(progressMessage);
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
	
	
	public class UpdateProgress implements Runnable{
		private double progress;
		
		public UpdateProgress(double progress) {
			this.progress = progress;
		}

		@Override
		public void run() {
			updateProgress(progress);
		}
		
	}

}
