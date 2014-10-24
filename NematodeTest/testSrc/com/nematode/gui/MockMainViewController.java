package com.nematode.gui;

public class MockMainViewController implements MainViewControllerInterface {

	private final MockNematodeFrame mockNematodeFrame = new MockNematodeFrame();

	@Override
	public ExtendableJFrame getMainView() {
		return this.mockNematodeFrame;
	}

}
