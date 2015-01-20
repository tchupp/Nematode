package com.nematode.model;

public class MockVideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video = new MockVideo();
	private boolean setVideoWasCalled = false;

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
}
