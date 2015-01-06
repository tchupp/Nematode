package com.nematode.gui;

public class MockToolbarPanelViewController implements ToolbarPanelViewControllerInterface {

	private boolean playButtonPressedWasCalled;

	@Override
	public void playButtonPressed() {
		this.playButtonPressedWasCalled = true;
	}

	public boolean wasPlayButtonPressedCalled() {
		return this.playButtonPressedWasCalled;
	}

	@Override
	public ExtendableJPanel getToolbarPanel() {
		return new ExtendableJPanel();
	}

}
