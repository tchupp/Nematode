package com.nematode.gui;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.image.MockVideoFrameHandler;
import com.nematode.unittesting.AssertTestCase;

public class TrackingPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(TrackingPanelViewControllerInterface.class,
				TrackingPanelViewController.class);
	}

	@Test
	public void testGetsTrackingPanel() throws Exception {
		final TrackingPanelViewController trackingPanelViewController = new TrackingPanelViewController();

		assertIsOfTypeAndGet(TrackingPanel.class, trackingPanelViewController.getTrackingPanel());
	}

	@Test
	public void testConstructorAddsListener_ScanImageButtonOnPanel() throws Exception {
		final TrackingPanelViewController viewController = new TrackingPanelViewController();
		final TrackingPanel trackingPanel = assertIsOfTypeAndGet(TrackingPanel.class,
				viewController.getTrackingPanel());
		final JButton scanButton = trackingPanel.getBeginScanButton();

		assertEquals(1, scanButton.getActionListeners().length);
		final BeginScanButtonActionListener buttonActionListener = assertIsOfTypeAndGet(
				BeginScanButtonActionListener.class, scanButton.getActionListeners()[0]);
		final TrackingPanelViewControllerInterface actualViewController = buttonActionListener
				.getPanelViewController();
		assertSame(viewController, actualViewController);
	}

	@Test
	public void testUpdateImageCallsScan_AndUpdateDisplayImage_OnFrameHandler() throws Exception {

		final MockVideoFrameHandler mockHandler = new MockVideoFrameHandler() {
			@Override
			public void scanImage() {
				assertFalse(wasBuildVideoFrameCalled());
				super.scanImage();
			}

			@Override
			public void updateDisplayImageFromScannedObjects() {
				assertTrue(wasScanImageCalled());
				super.updateDisplayImageFromScannedObjects();
			};
		};

		final TrackingPanelViewController viewController = new TrackingPanelViewController();

		assertFalse(mockHandler.wasScanImageCalled());
		assertFalse(mockHandler.wasUpdateDisplayImageFromScannedImageCalled());
		viewController.updateImage();
		assertFalse(mockHandler.wasScanImageCalled());
		assertFalse(mockHandler.wasUpdateDisplayImageFromScannedImageCalled());

	}
}
