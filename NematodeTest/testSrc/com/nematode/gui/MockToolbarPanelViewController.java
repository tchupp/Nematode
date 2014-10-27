package com.nematode.gui;

public class MockToolbarPanelViewController implements ToolbarPanelViewControllerInterface {

	@Override
	public ExtendableJPanel getToolbarPanel() {
		return new ExtendableJPanel();
	}

}
