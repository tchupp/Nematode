package com.nematode.model;

import org.junit.Test;

import com.nematode.gui.MockPanelViewController;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameImageChangeObserverTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeVideoFrameObserverInterface.class,
				VideoFrameImageChangeObserver.class);
	}

	@Test
	public void testGetViewController() throws Exception {
		final MockPanelViewController panelViewController = new MockPanelViewController();
		final VideoFrameImageChangeObserver imageChangeObserver = new VideoFrameImageChangeObserver(
				panelViewController);
		assertSame(panelViewController,
				imageChangeObserver.getPanelViewController());
	}

	@Test
		public void testNotifyVideoFrameHasBeenSet() throws Exception {
			final MockPanelViewController panelViewController = new MockPanelViewController();
			final VideoFrameImageChangeObserver observer = new VideoFrameImageChangeObserver(
					panelViewController);
			assertFalse(panelViewController.wasUpdateImageCalled());
			observer.notifyVideoFrameHasBeenSet();
			assertTrue(panelViewController.wasUpdateImageCalled());
		}
}
