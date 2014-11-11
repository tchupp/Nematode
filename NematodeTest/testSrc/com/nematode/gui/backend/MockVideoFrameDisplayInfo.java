package com.nematode.gui.backend;

public class MockVideoFrameDisplayInfo implements VideoFrameDisplayInfoInterface {

	private int frameNumberToReturn = 0;
	private boolean getFrameNumberWasCalled = false;

	@Override
	public int getFrameNumber() {
		this.getFrameNumberWasCalled = true;
		return this.frameNumberToReturn;
	}

	public boolean wasGetFrameNumberCalled() {
		return this.getFrameNumberWasCalled;
	}

	public void setFrameNumber(final int frameNumberToReturn) {
		this.frameNumberToReturn = frameNumberToReturn;
	}

}
