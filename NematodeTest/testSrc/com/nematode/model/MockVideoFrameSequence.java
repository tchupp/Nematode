package com.nematode.model;

public class MockVideoFrameSequence implements VideoFrameSequenceInterface {

	private VideoFrameInterface frameToReturn;
	private int size;
	private int frameNumberToGet;
	private boolean getFrameWasCalled = false;
	private boolean clearWasCalled = false;

	@Override
	public VideoFrameInterface getVideoFrame(final Integer frameNumber) {
		this.frameNumberToGet = frameNumber;
		this.getFrameWasCalled = true;
		return this.frameToReturn;
	}

	public boolean wasGetVideoFrameCalled() {
		return this.getFrameWasCalled;
	}

	public void setFrameToReturn(final VideoFrameInterface frameToReturn) {
		this.frameToReturn = frameToReturn;
	}

	public int getFrameNumberToGet() {
		return this.frameNumberToGet;
	}

	@Override
	public int size() {
		return this.size;
	}

	public void setSize(final int size) {
		this.size = size;
	}

	@Override
	public void addVideoFrame(final Integer index, final VideoFrameInterface videoFrame) {
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void clear() {
		this.clearWasCalled = true;
	}

	public boolean wasClearCalled() {
		return this.clearWasCalled;
	}

}
