package com.nematode.gui;

public class MockVideoPanelViewController implements VideoPanelViewControllerInterface {

	private boolean updateImageWasCalled;

	@Override
	public ExtendableJPanel getVideoPanel() {
		return new ExtendableJPanel();
	}

	@Override
	public void updateImage() {
		this.updateImageWasCalled = true;
	}

	public boolean wasUpdateImageCalled() {
		return this.updateImageWasCalled;
	}

}
