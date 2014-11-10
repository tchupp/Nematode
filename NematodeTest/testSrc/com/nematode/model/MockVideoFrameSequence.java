package com.nematode.model;

public class MockVideoFrameSequence implements VideoFrameSequenceInterface {

	private VideoFrameInterface frameToReturn;
	private int size;
	private int frameNumberToGet;
	private boolean getFrameWasCalled = false;

	@Override
	public VideoFrameInterface getFrame(final int frameNumber) {
		this.frameNumberToGet = frameNumber;
		this.getFrameWasCalled = true;
		return this.frameToReturn;
	}

	public boolean wasGetFrameCalled() {
		return this.getFrameWasCalled;
	}

	public void setFrameToReturn(final VideoFrameInterface frameToReturn) {
		this.frameToReturn = frameToReturn;
	}

	public int getFrameNumberToGet() {
		return this.frameNumberToGet;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	public void setSize(final int size) {
		this.size = size;
	}

}
