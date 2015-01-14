package com.nematode.gui;

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
		final MainWindowViewController mainWindowViewController = new MainWindowViewController();
		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				mainWindowViewController);

		nematodeTrackingLauncher.launchApplication();
	}
}
