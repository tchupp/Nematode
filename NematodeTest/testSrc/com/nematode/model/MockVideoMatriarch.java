package com.nematode.model;

public class MockVideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video = new MockVideo();
	private boolean getVideoWasCalled = false;
	private boolean setVideoWasCalled = false;
	private int numberOfObservers = 0;
	private VideoObserverInterface observerToAdd;
	private VideoObserverInterface observerToRemove;

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

	@Override
	public void addObserver(final VideoObserverInterface observer) {
		this.observerToAdd = observer;
		this.numberOfObservers++;
	}

	@Override
	public void removeObserver(final VideoObserverInterface observer) {
		this.observerToRemove = observer;
		this.numberOfObservers--;
	}

	public int getNumberOfObservers() {
		return this.numberOfObservers;
	}

	public VideoObserverInterface getObserverToAdd() {
		return this.observerToAdd;
	}

	public VideoObserverInterface getObserverToRemove() {
		return this.observerToRemove;
	}
}
