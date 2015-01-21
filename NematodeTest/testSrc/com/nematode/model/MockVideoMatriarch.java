package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockVideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video = new MockVideo();
	private boolean setVideoWasCalled = false;
	private boolean startVideoWasCalled;
	private boolean stopVideoWasCalled;
	private boolean grabCurrentFrameWasCalled;
	private Mat currentFrameToReturn;

	public VideoInterface getVideo() {
		return this.video;
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.setVideoWasCalled = true;
		this.video = video;
	}

	public boolean wasSetVideoCalled() {
		return this.setVideoWasCalled;
	}

	@Override
	public Mat grabCurrentFrame() {
		this.grabCurrentFrameWasCalled = true;
		return this.currentFrameToReturn;
	}

	public void setCurrentFrameToReturn(final Mat currentFrameToReturn) {
		this.currentFrameToReturn = currentFrameToReturn;
	}

	public boolean wasGrabCurrentFrameCalled() {
		return this.grabCurrentFrameWasCalled;
	}

	@Override
	public void startVideo() {
		this.startVideoWasCalled = true;
	}

	public boolean wasStartVideoCalled() {
		return this.startVideoWasCalled;
	}

	@Override
	public void stopVideo() {
		this.stopVideoWasCalled = true;
	}

	public boolean wasStopVideoCalled() {
		return this.stopVideoWasCalled;
	}
}
