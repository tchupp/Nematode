package com.nematode.gui;

import org.opencv.core.Core;

public class NematodeTrackingLauncher {

	private final MainWindowControllerInterface mainWindowViewController;

	public NematodeTrackingLauncher(final MainWindowControllerInterface mainWindowViewController) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();

		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				mainWindowViewController);

		nematodeTrackingLauncher.launchApplication();
	}
}
