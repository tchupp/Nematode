package com.nematode.gui.main;

import com.nematode.fileIO.VideoFileChooser;
import com.nematode.gui.ExtendableJFrame;
import com.nematode.gui.MainWindowControllerInterface;
import com.nematode.model.VideoMatriarchInterface;

public class MainWindowViewController implements MainWindowControllerInterface {

	private final AbstractMainWindow mainWindow;
	private final VideoMatriarchInterface videoMatriarch;

	public MainWindowViewController(final AbstractMainWindow mainWindow,
			final VideoMatriarchInterface videoMatriarch) {
		this.mainWindow = mainWindow;
		this.videoMatriarch = videoMatriarch;

		addListenersToMainWindow();
	}

	private void addListenersToMainWindow() {
		this.mainWindow.addWindowListener(new MainWindowCloseListener(this));
		this.mainWindow.addListenerToPlayButton(new PlayButtonListener(this));
		this.mainWindow.addListenerToPauseButton(new PauseButtonListener(this));
		this.mainWindow.addListenerToOpenVideoButton(new OpenVideoButtonListener(this,
				new VideoFileChooser()));
	}

	@Override
	public void showView() {
		this.mainWindow.setVisible(true);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void playButtonPressed() {
	}

	@Override
	public void pauseButtonPressed() {
	}

	public ExtendableJFrame getMainWindow() {
		return this.mainWindow;
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}
}
