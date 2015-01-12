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

	@Override
	public void addObserver(final ToolbarObserverInterface observer) {
	}

	@Override
	public void removeObserver(final ToolbarObserverInterface observer) {
	}

}
