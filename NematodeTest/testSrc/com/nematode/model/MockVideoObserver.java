package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockVideoObserver implements VideoObserverInterface {

	private boolean notifyVideoHasBeenSetWasCalled = false;
	private Mat thumbnailPassedIn;

	@Override
	public void notifyVideoHasBeenSet(final Mat thumbnail) {
		this.thumbnailPassedIn = thumbnail;
		this.notifyVideoHasBeenSetWasCalled = true;
	}

	public Mat getThumbnailPassedIn() {
		return this.thumbnailPassedIn;
	}

	public boolean wasNotifyVideoHasBeenSetCalled() {
		return this.notifyVideoHasBeenSetWasCalled;
	}
}
