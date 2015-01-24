package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockVideo implements VideoInterface {

	private Mat thumbnailToReturn;
	private Mat grabMatToReturn;
	private boolean getThumbnailWasCalled = false;
	private boolean grabWasCalled;
	private boolean startWasCalled;
	private boolean stopWasCalled;
	private double frameRateToReturn;

	@Override
	public void start() {
		this.startWasCalled = true;
	}

	public boolean wasStartCalled() {
		return this.startWasCalled;
	}

	@Override
	public void stop() {
		this.stopWasCalled = true;
	}

	public boolean wasStopCalled() {
		return this.stopWasCalled;
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
	public Mat grab() {
		this.grabWasCalled = true;
		return this.grabMatToReturn;
	}

	public boolean wasGrabCalled() {
		return this.grabWasCalled;
	}

	public void setGrabMatToReturn(final Mat grabMatToReturn) {
		this.grabMatToReturn = grabMatToReturn;
	}

	@Override
	public double getFrameRate() {
		return this.frameRateToReturn;
	}

	public void setFrameRateToReturn(final double frameRateToReturn) {
		this.frameRateToReturn = frameRateToReturn;
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
