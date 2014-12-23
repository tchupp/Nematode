package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockVideo implements VideoInterface {

	private Mat thumbnailToReturn = new Mat();
	private boolean getThumbnailWasCalled = false;

	@Override
	public void start() {
		// TODO Auto-generated method stub
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
	}

	@Override
	public Mat grab() {
		// TODO Auto-generated method stub
		return null;
	}

}
