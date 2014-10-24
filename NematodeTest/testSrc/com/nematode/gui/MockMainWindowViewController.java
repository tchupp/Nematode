package com.nematode.gui;

public class MockMainWindowViewController implements MainWindowControllerInterface {

	private final MockNematodeFrame mockNematodeFrame = new MockNematodeFrame();

	@Override
	public ExtendableJFrame getMainWindow() {
		return this.mockNematodeFrame;
	}

}
