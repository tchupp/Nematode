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
	public void testGetsNematodeTrackingPanel() throws Exception {
		final TrackingPanelViewController trackingPanelViewController = new TrackingPanelViewController(
				new MockVideoFrameHandler());

		assertIsOfTypeAndGet(TrackingPanel.class, trackingPanelViewController.getTrackingPanel());
	}

	@Test
	public void testGetsVideoFrame() throws Exception {
		final MockVideoFrameHandler expectedFrameHandler = new MockVideoFrameHandler();
		final TrackingPanelViewController viewController = new TrackingPanelViewController(
				expectedFrameHandler);
		assertSame(expectedFrameHandler, viewController.getVideoFrameHandler());
	}

	@Test
	public void testConstructorAddsListener_ScanImageButtonOnPanel() throws Exception {
		final TrackingPanelViewController viewController = new TrackingPanelViewController(
				new MockVideoFrameHandler());
		final TrackingPanel trackingPanel = assertIsOfTypeAndGet(TrackingPanel.class,
				viewController.getTrackingPanel());
		final JButton scanButton = trackingPanel.getScanButton();
		assertEquals(1, scanButton.getActionListeners().length);
		final ScanImageButtonActionListener buttonActionListener = assertIsOfTypeAndGet(
				ScanImageButtonActionListener.class, scanButton.getActionListeners()[0]);
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

		final TrackingPanelViewController viewController = new TrackingPanelViewController(
				mockHandler);

		assertFalse(mockHandler.wasScanImageCalled());
		assertFalse(mockHandler.wasUpdateDisplayImageFromScannedImageCalled());
		viewController.updateImage();
		assertTrue(mockHandler.wasScanImageCalled());
		assertTrue(mockHandler.wasUpdateDisplayImageFromScannedImageCalled());

	}
}
