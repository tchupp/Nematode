package com.nematode.gui;

public class MockNematodeFrame extends ExtendableJFrame {

	private static final long serialVersionUID = 1L;
	private boolean isVisible;
	private boolean setVisibleWasCalled;

	@Override
	public void setVisible(final boolean isVisable) {
		this.isVisible = isVisable;
		this.setVisibleWasCalled = true;
	}

	public boolean wasSetVisibleCalled() {
		return this.setVisibleWasCalled;
	}

	@Override
	public boolean isVisible() {
		return this.isVisible;
	}

}
