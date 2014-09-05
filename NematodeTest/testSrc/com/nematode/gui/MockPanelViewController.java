package com.nematode.gui;

public class MockPanelViewController implements
NematodePanelViewControllerInterface {

	private boolean updateImageWasCalled = false;

	@Override
	public NematodePanel getNematodePanel() {
		return new NematodePanel();
	}

	@Override
	public void updateImage() {
		this.updateImageWasCalled = true;
	}

	public boolean wasUpdateImageCalled() {
		return this.updateImageWasCalled;
	}

}
