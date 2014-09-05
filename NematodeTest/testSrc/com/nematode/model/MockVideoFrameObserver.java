package com.nematode.model;

public class MockVideoFrameObserver implements
NematodeVideoFrameObserverInterface {

	private boolean notifyFrameHasBeenSetWasCalled = false;

	@Override
	public void notifyFrameHasBeenSet() {
		this.notifyFrameHasBeenSetWasCalled = true;
	}

	public boolean wasNotifyFrameHasBeenSetCalled() {
		return this.notifyFrameHasBeenSetWasCalled;
	}
}
