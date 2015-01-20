package com.nematode.gui.main;

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
}
