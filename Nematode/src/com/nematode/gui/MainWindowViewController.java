package com.nematode.gui;

import com.nematode.model.VideoMatriarchInterface;
import com.nematode.model.VideoObserverInterface;
import com.nematode.model.VideoSetObserver;

public class MainWindowViewController implements MainWindowControllerInterface {

	private final ExtendableJFrame mainWindow;
	private final VideoMatriarchInterface videoMatriarch;
	private final VideoObserverInterface videoSetObserver;

	public MainWindowViewController(final ExtendableJFrame mainWindow,
			final VideoMatriarchInterface videoMatriarch) {
		this.mainWindow = mainWindow;
		this.mainWindow.addWindowListener(new MainWindowCloseListener(this));

		this.videoMatriarch = videoMatriarch;

		this.videoSetObserver = new VideoSetObserver(null);
		this.videoMatriarch.addObserver(this.videoSetObserver);
	}

	@Override
	public void showView() {
		this.mainWindow.setVisible(true);
	}

	@Override
	public void dispose() {
		this.videoMatriarch.removeObserver(this.videoSetObserver);
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}

	public VideoObserverInterface getVideoSetObserver() {
		return this.videoSetObserver;
	}

	public ExtendableJFrame getMainWindow() {
		return this.mainWindow;
	}
}
