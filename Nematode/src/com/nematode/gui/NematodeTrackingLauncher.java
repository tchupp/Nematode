package com.nematode.gui;

public class NematodeTrackingLauncher {

	private final MainViewControllerInterface mainViewController;

	public NematodeTrackingLauncher(
			final MainViewControllerInterface mainViewController) {
		this.mainViewController = mainViewController;
	}

	public void launchApplication() {
		final NematodeFrame nematodeMainView = this.mainViewController
				.getNematodeMainView();
		nematodeMainView.setVisible(true);
	}

	public MainViewControllerInterface getMainViewController() {
		return this.mainViewController;
	}

	public static void main(final String[] args) {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();

		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				nematodeMainViewController);

		nematodeTrackingLauncher.launchApplication();
	}
}