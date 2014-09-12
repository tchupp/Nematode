package com.nematode.model;

import org.junit.Test;

import com.nematode.gui.MockPanelViewController;
import com.nematode.unittesting.AssertTestCase;

public class DisplayFrameImageChangeObserverTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeVideoFrameObserverInterface.class,
				DisplayFrameImageChangeObserver.class);
	}

	@Test
	public void testGetViewController() throws Exception {
		final MockPanelViewController panelViewController = new MockPanelViewController();
		final DisplayFrameImageChangeObserver imageChangeObserver = new DisplayFrameImageChangeObserver(
				panelViewController);
		assertSame(panelViewController,
				imageChangeObserver.getPanelViewController());
	}

	@Test
	public void testNotifyDisplayFrameHasBeenSet() throws Exception {
		final MockPanelViewController panelViewController = new MockPanelViewController();
		final DisplayFrameImageChangeObserver observer = new DisplayFrameImageChangeObserver(
				panelViewController);
		assertFalse(panelViewController.wasUpdateImageCalled());
		observer.notifyDisplayFrameHasBeenSet();
		assertTrue(panelViewController.wasUpdateImageCalled());
	}
}
