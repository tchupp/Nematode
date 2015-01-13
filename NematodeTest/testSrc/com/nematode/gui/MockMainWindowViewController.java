package com.nematode.gui;

public class MockMainWindowViewController implements MainWindowControllerInterface {

	private ExtendableJFrame mockNematodeFrame;
	private boolean disposeWasCalled;

	public void setMockNematodeFrame(final ExtendableJFrame mockNematodeFrame) {
		this.mockNematodeFrame = mockNematodeFrame;
	}

	@Override
	public ExtendableJFrame getMainWindow() {
		return this.mockNematodeFrame;
	}

	@Override
	public void dispose() {
		this.disposeWasCalled = true;
	}

	public boolean wasDisposeCalled() {
		return this.disposeWasCalled;
	}
}
