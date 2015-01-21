package com.nematode.gui;

import org.junit.Test;

import com.nematode.gui.main.MainWindow;
import com.nematode.gui.main.MainWindowViewController;
import com.nematode.image.processing.ImageResizer;
import com.nematode.model.VideoMatriarch;
import com.nematode.unittesting.AssertTestCase;

public class NematodeTrackingLauncherTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeTrackingLauncherInterface.class,
				NematodeTrackingLauncher.class);
	}

	@Test
	public void testCorrectlySetsUpMainWindowViewController_AndAllArguments() throws Exception {
		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher();

		final MainWindowViewController viewController = assertIsOfTypeAndGet(
				MainWindowViewController.class, nematodeTrackingLauncher.getViewController());

		assertIsOfTypeAndGet(VideoMatriarch.class, viewController.getVideoMatriarch());

		final MainWindow mainWindow = assertIsOfTypeAndGet(MainWindow.class,
				viewController.getMainWindow());

		assertIsOfTypeAndGet(ImageResizer.class, mainWindow.getImageResizer());
	}

	@Test
	public void testLaunchApplicationSetsMainWindowToVisable() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();

		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher();
		nematodeTrackingLauncher.setViewController(mockMainWindowViewController);

		assertFalse(mockMainWindowViewController.wasShowViewCalled());
		nematodeTrackingLauncher.launchApplication();
		assertTrue(mockMainWindowViewController.wasShowViewCalled());
	}
}
