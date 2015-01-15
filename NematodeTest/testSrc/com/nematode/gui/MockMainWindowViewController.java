package com.nematode.gui;

public class MockMainWindowViewController implements MainWindowControllerInterface {

	private ExtendableJFrame mainWindow;
	private boolean disposeWasCalled;

	public void setMainWindowToReturn(final ExtendableJFrame setMainWindowToReturn) {
		this.mainWindow = setMainWindowToReturn;
	}

	@Override
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
}
