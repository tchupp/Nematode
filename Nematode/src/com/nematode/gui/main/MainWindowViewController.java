package com.nematode.gui.main;

import com.nematode.gui.ExtendableJFrame;
import com.nematode.gui.MainWindowControllerInterface;
import com.nematode.model.VideoMatriarchInterface;

public class MainWindowViewController implements MainWindowControllerInterface {

	private final ExtendableJFrame mainWindow;
	private final VideoMatriarchInterface videoMatriarch;

	public MainWindowViewController(final ExtendableJFrame mainWindow,
			final VideoMatriarchInterface videoMatriarch) {
		this.mainWindow = mainWindow;
		this.mainWindow.addWindowListener(new MainWindowCloseListener(this));

		this.videoMatriarch = videoMatriarch;
	}

	@Override
	public void showView() {
		this.mainWindow.setVisible(true);
	}

	@Override
	public void dispose() {
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}

	public ExtendableJFrame getMainWindow() {
		return this.mainWindow;
	}
}
