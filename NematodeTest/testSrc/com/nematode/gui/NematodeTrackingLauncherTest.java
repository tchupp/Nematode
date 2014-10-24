package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeTrackingLauncherTest extends AssertTestCase {

	@Test
	public void testGetsMainViewController() throws Exception {
		final MockMainViewController expectedMainViewController = new MockMainViewController();
		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				expectedMainViewController);

		assertSame(expectedMainViewController,
				nematodeTrackingLauncher.getMainViewController());
	}

	@Test
	public void testLaunchApplicationSetsFrameVisable() throws Exception {
		final MockMainViewController mockMainViewController = new MockMainViewController();
		final NematodeTrackingLauncher nematodeTrackingLauncher = new NematodeTrackingLauncher(
				mockMainViewController);

		final MockNematodeFrame mainView = assertIsOfTypeAndGet(
				MockNematodeFrame.class,
				mockMainViewController.getMainView());

		assertFalse(mainView.isVisible());
		nematodeTrackingLauncher.launchApplication();
		assertTrue(mainView.isVisible());

		mainView.dispose();
	}
}
