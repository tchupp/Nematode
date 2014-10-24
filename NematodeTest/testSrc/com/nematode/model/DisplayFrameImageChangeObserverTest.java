package com.nematode.model;

import org.junit.Test;

import com.nematode.gui.MockVideoPanelViewController;
import com.nematode.unittesting.AssertTestCase;

public class DisplayFrameImageChangeObserverTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameObserverInterface.class,
				DisplayFrameImageChangeObserver.class);
	}

	@Test
	public void testGetViewController() throws Exception {
		final MockVideoPanelViewController panelViewController = new MockVideoPanelViewController();
		final DisplayFrameImageChangeObserver imageChangeObserver = new DisplayFrameImageChangeObserver(
				panelViewController);
		assertSame(panelViewController, imageChangeObserver.getPanelViewController());
	}

	@Test
	public void testNotifyDisplayFrameHasBeenSet() throws Exception {
		final MockVideoPanelViewController panelViewController = new MockVideoPanelViewController();
		final DisplayFrameImageChangeObserver observer = new DisplayFrameImageChangeObserver(
				panelViewController);
		assertFalse(panelViewController.wasUpdateImageCalled());
		observer.notifyDisplayFrameHasBeenSet();
		assertTrue(panelViewController.wasUpdateImageCalled());
	}
}
