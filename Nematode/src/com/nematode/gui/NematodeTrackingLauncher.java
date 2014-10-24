package com.nematode.gui;

public class NematodeTrackingLauncher {

	private final MainViewControllerInterface mainViewController;

	public NematodeTrackingLauncher(
			final MainViewControllerInterface mainViewController) {
		this.mainViewController = mainViewController;
	}

	public void launchApplication() {
		final ExtendableJFrame mainView = this.mainViewController
				.getMainView();
		mainView.setVisible(true);
	}

	public MainViewControllerInterface getMainViewController() {
		return this.mainViewController;
	}

	public static void main(final String[] args) {
		final MainViewController mainViewController = new MainViewController();

		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				mainViewController);

		nematodeTrackingLauncher.launchApplication();
	}
}