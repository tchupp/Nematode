package com.nematode.model;

public class MockVideoFrameObserver implements
		NematodeVideoFrameObserverInterface {

	private boolean notifyVideoFrameHasBeenSetWasCalled = false;
	private boolean notifyDisplayFrameHasBeenSetWasCalled = false;

	@Override
	public void notifyVideoFrameHasBeenSet() {
		this.notifyVideoFrameHasBeenSetWasCalled = true;
	}

	public boolean wasNotifyVideoFrameHasBeenSetCalled() {
		return this.notifyVideoFrameHasBeenSetWasCalled;
	}

	@Override
	public void notifyDisplayFrameHasBeenSet() {
		this.notifyDisplayFrameHasBeenSetWasCalled = true;
	}

	public boolean wasNotifyDisplayFrameHasBeenSetCalled() {
		return this.notifyDisplayFrameHasBeenSetWasCalled;
	}

}
