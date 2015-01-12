package com.nematode.gui;

public class MockToolbarObserver implements ToolbarObserverInterface {

	private boolean notifyPlayButtonPressedWasCalled;

	@Override
	public void notifyPlayButtonPressed() {
		this.notifyPlayButtonPressedWasCalled = true;
	}

	public boolean wasNotifyPlayButtonPressedCalled() {
		return this.notifyPlayButtonPressedWasCalled;
	}

}
