package com.nematode.gui.main;

import org.bytedeco.javacpp.opencv_core.Mat;

public class MockMainWindow extends AbstractMainWindow {

	private static final long serialVersionUID = 1L;
	private boolean addListenerToPlayButtonWasCalled;
	private boolean addListenerToPauseButtonWasCalled;
	private boolean addListenerToOpenVideoButtonWasCalled;
	private MainWindowActionListener listenerToAddToPlayButton;
	private MainWindowActionListener listenerToAddToPauseButton;
	private MainWindowActionListener listenerToAddToOpenVideoButton;
	private boolean isVisable;
	private boolean setVisibleWasCalled;
	private Mat imageToDisplay;
	private boolean displayImageWasCalled;
	private boolean disposeWasCalled;
	private MainWindowActionListener listenerToAddToStopButton;
	private boolean addListenerToStopButtonWasCalled;

	@Override
	public void addListenerToPlayButton(final MainWindowActionListener listener) {
		this.listenerToAddToPlayButton = listener;
		this.addListenerToPlayButtonWasCalled = true;
	}

	public boolean wasAddListenerToPlayButtonCalled() {
		return this.addListenerToPlayButtonWasCalled;
	}

	public MainWindowActionListener getListenerToAddToPlayButton() {
		return this.listenerToAddToPlayButton;
	}

	@Override
	public void addListenerToPauseButton(final MainWindowActionListener listener) {
		this.listenerToAddToPauseButton = listener;
		this.addListenerToPauseButtonWasCalled = true;
	}

	public boolean wasAddListenerToPauseButtonCalled() {
		return this.addListenerToPauseButtonWasCalled;
	}

	public MainWindowActionListener getListenerToAddToPauseButton() {
		return this.listenerToAddToPauseButton;
	}

	@Override
	public void addListenerToStopButton(final MainWindowActionListener listener) {
		this.listenerToAddToStopButton = listener;
		this.addListenerToStopButtonWasCalled = true;
	}

	public boolean wasAddListenerToStopButtonCalled() {
		return this.addListenerToStopButtonWasCalled;
	}

	public MainWindowActionListener getListenerToAddToStopButton() {
		return this.listenerToAddToStopButton;
	}

	@Override
	public void addListenerToOpenVideoButton(final MainWindowActionListener listener) {
		this.listenerToAddToOpenVideoButton = listener;
		this.addListenerToOpenVideoButtonWasCalled = true;
	}

	public boolean wasAddListenerToOpenVideoButtonCalled() {
		return this.addListenerToOpenVideoButtonWasCalled;
	}

	public MainWindowActionListener getListenerToAddToOpenVideoButton() {
		return this.listenerToAddToOpenVideoButton;
	}

	@Override
	public void setVisible(final boolean visable) {
		this.isVisable = visable;
		this.setVisibleWasCalled = true;
	}

	public boolean wasSetVisableCalled() {
		return this.setVisibleWasCalled;
	}

	@Override
	public boolean isVisible() {
		return this.isVisable;
	}

	@Override
	public void displayImage(final Mat displayImage) {
		this.imageToDisplay = displayImage;
		this.displayImageWasCalled = true;
	}

	public boolean wasDisplayImageCalled() {
		return this.displayImageWasCalled;
	}

	public Mat getImageToDisplay() {
		return this.imageToDisplay;
	}

	@Override
	public void dispose() {
		this.disposeWasCalled = true;
	}

	public boolean wasDisposeCalled() {
		return this.disposeWasCalled;
	}

}
