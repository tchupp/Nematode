package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeTrackingLauncherTest extends AssertTestCase {

	@Test
	public void testGetsMainWindowViewController() throws Exception {
		final MockMainWindowViewController expectedViewController = new MockMainWindowViewController();
		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				expectedViewController);

		assertSame(expectedViewController, nematodeTrackingLauncher.getMainWindowViewController());
	}

	@Test
	public void testLaunchApplicationSetsFrameVisable() throws Exception {
		final MockMainWindowViewController mockMainWindowViewController = new MockMainWindowViewController();
		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				mockMainWindowViewController);

		final MockNematodeFrame mainWindow = assertIsOfTypeAndGet(MockNematodeFrame.class,
				mockMainWindowViewController.getMainWindow());

		assertFalse(mainWindow.isVisible());
		nematodeTrackingLauncher.launchApplication();
		assertTrue(mainWindow.isVisible());

		mainWindow.dispose();
	}
}
