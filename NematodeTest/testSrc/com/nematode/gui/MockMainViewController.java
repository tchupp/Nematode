package com.nematode.gui;

public class MockMainViewController implements MainViewControllerInterface {

	private final MockNematodeFrame mockNematodeFrame = new MockNematodeFrame();

	@Override
	public NematodeFrame getNematodeMainView() {
		return this.mockNematodeFrame;
	}

}
