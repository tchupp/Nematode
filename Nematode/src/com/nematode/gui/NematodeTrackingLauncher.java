package com.nematode.gui;

import com.nematode.model.VideoMatriarch;

public class NematodeTrackingLauncher {

	private final MainWindowControllerInterface mainWindowViewController;

	public NematodeTrackingLauncher(final MainWindowControllerInterface mainWindowViewController) {
		this.mainWindowViewController = mainWindowViewController;
	}

	public void launchApplication() {
		final ExtendableJFrame mainWindow = this.mainWindowViewController.getMainWindow();
		mainWindow.setVisible(true);
	}

	public MainWindowControllerInterface getMainWindowViewController() {
		return this.mainWindowViewController;
	}

	public static void main(final String[] args) {
		final MainWindow mainWindow = new MainWindow();
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MainWindowViewController mainWindowViewController = new MainWindowViewController(
				mainWindow, videoMatriarch);

		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				mainWindowViewController);

		nematodeTrackingLauncher.launchApplication();
	}
}
