package com.nematode.model;

public class MockVideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video = new MockVideo();
	private boolean getVideoWasCalled = false;
	private boolean setVideoWasCalled = false;

	@Override
	public VideoInterface getVideo() {
		this.getVideoWasCalled = true;
		return this.video;
	}

	public boolean wasGetVideoCalled() {
		return this.getVideoWasCalled;
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.setVideoWasCalled = true;
		this.video = video;
	}

	public boolean wasSetVideoCalled() {
		return this.setVideoWasCalled;
	}
}
