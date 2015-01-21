package com.nematode.gui;

import com.nematode.gui.main.AbstractMainWindow;
import com.nematode.model.VideoInterface;

public class MockMainWindowViewController implements MainWindowControllerInterface {

	private AbstractMainWindow mainWindow;
	private boolean disposeWasCalled;
	private boolean showViewWasCalled;
	private boolean playButtonPressedWasCalled;
	private boolean pauseButtonPressedWasCalled;
	private boolean setVideoWasCalled;
	private VideoInterface videoToSet;

	public void setMainWindowToReturn(final AbstractMainWindow setMainWindowToReturn) {
		this.mainWindow = setMainWindowToReturn;
	}

	public AbstractMainWindow getMainWindow() {
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

	@Override
	public void setVideo(final VideoInterface video) {
		this.videoToSet = video;
		this.setVideoWasCalled = true;
	}

	public boolean wasSetVideoCalled() {
		return this.setVideoWasCalled;
	}

	public VideoInterface getVideoToSet() {
		return this.videoToSet;
	}
}
