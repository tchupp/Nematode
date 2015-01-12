package com.nematode.gui;

public interface ToolbarPanelViewControllerInterface {

	public void playButtonPressed();

	public ExtendableJPanel getToolbarPanel();

	public void addObserver(ToolbarObserverInterface observer);

	public void removeObserver(ToolbarObserverInterface observer);

}
