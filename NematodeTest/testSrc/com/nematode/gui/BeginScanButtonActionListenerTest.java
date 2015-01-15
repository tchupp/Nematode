package com.nematode.gui;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class BeginScanButtonActionListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ActionListener.class, BeginScanButtonActionListener.class);
	}

	@Test
	public void testGetTrackingPanelViewController() throws Exception {
		final MockTrackingPanelViewController expectedViewController = new MockTrackingPanelViewController();
		final BeginScanButtonActionListener buttonActionListener = new BeginScanButtonActionListener(
				expectedViewController);
		final TrackingPanelViewControllerInterface actualViewController = buttonActionListener
				.getPanelViewController();
		assertSame(expectedViewController, actualViewController);
	}
}
