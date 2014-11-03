package com.nematode.gui;

import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

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

	@Test
	public void testActionPerformedCallsUpdateImageOnViewController() throws Exception {
		final MockTrackingPanelViewController mockViewController = new MockTrackingPanelViewController();
		final BeginScanButtonActionListener buttonActionListener = new BeginScanButtonActionListener(
				mockViewController);

		assertFalse(mockViewController.wasUpdateImageCalled());
		buttonActionListener.actionPerformed(null);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				assertTrue(mockViewController.wasUpdateImageCalled());
			}
		});
	}
}
