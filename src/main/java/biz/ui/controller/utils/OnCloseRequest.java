package biz.ui.controller.utils;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public abstract class OnCloseRequest implements EventHandler<WindowEvent>{

	@Override
	abstract public void handle(WindowEvent event);
	
}
