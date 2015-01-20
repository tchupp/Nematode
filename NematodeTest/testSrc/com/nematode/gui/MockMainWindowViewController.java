package com.nematode.gui;

public class MockMainWindowViewController implements MainWindowControllerInterface {

	private ExtendableJFrame mainWindow;
	private boolean disposeWasCalled;
	private boolean showViewWasCalled;
	private boolean playButtonPressedWasCalled;
	private boolean pauseButtonPressedWasCalled;

	public void setMainWindowToReturn(final ExtendableJFrame setMainWindowToReturn) {
		this.mainWindow = setMainWindowToReturn;
	}

	public ExtendableJFrame getMainWindow() {
		return this.mainWindow;
	}

	@Override
	public void dispose() {
		this.disposeWasCalled = true;
	}

	public boolean wasDisposeCalled() {
		return this.disposeWasCalled;
	}

	@Override
	public void showView() {
		this.showViewWasCalled = true;
	}

	public boolean wasShowViewCalled() {
		return this.showViewWasCalled;
	}

	@Override
	public void playButtonPressed() {
		this.playButtonPressedWasCalled = true;
	}

	public boolean wasPlayButtonPressedCalled() {
		return this.playButtonPressedWasCalled;
	}

	@Override
	public void pauseButtonPressed() {
		this.pauseButtonPressedWasCalled = true;
	}

	public boolean wasPauseButtonPressedCalled() {
		return this.pauseButtonPressedWasCalled;
	}
}
