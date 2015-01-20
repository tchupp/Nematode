package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockVideo implements VideoInterface {

	private Mat thumbnailToReturn = new Mat();
	private boolean getThumbnailWasCalled = false;

	@Override
	public void start() {
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Mat getThumbnail() {
		this.getThumbnailWasCalled = true;
		return this.thumbnailToReturn;
	}

	public boolean wasGetThumbnailCalled() {
		return this.getThumbnailWasCalled;
	}

	public void setThumbnailToReturn(final Mat thumbnail) {
		this.thumbnailToReturn = thumbnail;
	}

	@Override
	public void stop() {
	}

	@Override
	public Mat grab() {
		return null;
	}

	@Override
	public double getFrameRate() {
		return 0;
	}

	@Override
	public long getDurration() {
		return 0;
	}

	@Override
	public int getFrameLength() {
		return 0;
	}

	@Override
	public int getCurrentFrame() {
		return 0;
	}
}
