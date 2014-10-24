package com.nematode.gui;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ScanImageButtonActionListenerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ActionListener.class, ScanImageButtonActionListener.class);
	}

	@Test
	public void testGetTrackingPanelViewController() throws Exception {
		final MockTrackingPanelViewController expectedViewController = new MockTrackingPanelViewController();
		final ScanImageButtonActionListener buttonActionListener = new ScanImageButtonActionListener(
				expectedViewController);
		final TrackingPanelViewControllerInterface actualViewController = buttonActionListener
				.getPanelViewController();
		assertSame(expectedViewController, actualViewController);
	}

	@Test
	public void testActionPerformedCallsUpdateImageOnViewController() throws Exception {
		final MockTrackingPanelViewController mockViewController = new MockTrackingPanelViewController();
		final ScanImageButtonActionListener buttonActionListener = new ScanImageButtonActionListener(
				mockViewController);

		assertFalse(mockViewController.wasUpdateImageCalled());
		buttonActionListener.actionPerformed(null);
		assertTrue(mockViewController.wasUpdateImageCalled());
	}
}
