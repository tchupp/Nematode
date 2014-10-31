package com.nematode.gui;

public class MockVideoPanelViewController implements VideoPanelViewControllerInterface {

	private boolean updateVideoDisplayWasCalled;

	@Override
	public ExtendableJPanel getVideoPanel() {
		return new ExtendableJPanel();
	}

	@Override
	public void updateVideoDisplay() {
		this.updateVideoDisplayWasCalled = true;
	}

	public boolean wasUpdateVideoDisplayCalled() {
		return this.updateVideoDisplayWasCalled;
	}

}
