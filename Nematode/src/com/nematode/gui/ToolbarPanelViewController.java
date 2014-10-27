package com.nematode.gui;

public class ToolbarPanelViewController implements ToolbarPanelViewControllerInterface {

	private final ToolbarPanel toolbarPanel;

	public ToolbarPanelViewController() {
		this.toolbarPanel = new ToolbarPanel();
	}

	@Override
	public ExtendableJPanel getToolbarPanel() {
		return this.toolbarPanel;
	}

}
