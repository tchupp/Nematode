package com.nematode.model;

public class MockVideoFrameSequence implements VideoFrameSequenceInterface {

	private VideoFrameInterface frameToReturn;
	private int size;
	private int frameNumberToGet;
	private boolean getFrameWasCalled = false;
	private boolean clearWasCalled = false;
	private boolean addVideoFrameWasCalled = false;
	private Integer frameIndexToAdd;
	private VideoFrameInterface videoFrameToAdd;

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
		this.frameIndexToAdd = index;
		this.videoFrameToAdd = videoFrame;
		this.addVideoFrameWasCalled = true;
	}

	public boolean wasAddVideoFrameCalled() {
		return this.addVideoFrameWasCalled;
	}

	public Integer getFrameIndexToAdd() {
		return this.frameIndexToAdd;
	}

	public VideoFrameInterface getVideoFrameToAdd() {
		return this.videoFrameToAdd;
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
