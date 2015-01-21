package com.nematode.gui;

import com.nematode.gui.main.MainWindow;
import com.nematode.gui.main.MainWindowViewController;
import com.nematode.image.processing.ImageResizer;
import com.nematode.model.VideoMatriarch;

public class NematodeTrackingLauncher implements NematodeTrackingLauncherInterface {

	private MainWindowControllerInterface viewController;

	public NematodeTrackingLauncher() {
		final ImageResizer imageResizer = new ImageResizer();
		final MainWindow mainWindow = new MainWindow(imageResizer);
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		this.viewController = new MainWindowViewController(mainWindow, videoMatriarch);
	}

	@Override
	public void launchApplication() {
		this.viewController.showView();
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}

	public void setViewController(final MainWindowControllerInterface viewController) {
		this.viewController = viewController;
	}

	public static void main(final String[] args) {
		final NematodeTrackingLauncherInterface nematodeTrackingLauncher = new NematodeTrackingLauncher();

		nematodeTrackingLauncher.launchApplication();
	}
}
