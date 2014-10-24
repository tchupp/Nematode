package com.nematode.gui;

public class MockTrackingPanelViewController implements TrackingPanelViewControllerInterface {

	private boolean updateImageWasCalled;

	@Override
	public void updateImage() {
		this.updateImageWasCalled = true;
	}

	public boolean wasUpdateImageCalled() {
		return this.updateImageWasCalled;
	}

	@Override
	public ExtendableJPanel getTrackingPanel() {
		return new ExtendableJPanel();
	}
}
