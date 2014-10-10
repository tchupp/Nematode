package com.nematode.gui;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.imaging.MockVideoFrameHandler;
import com.nematode.unittesting.AssertTestCase;

public class NematodeTrackingPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodePanelViewControllerInterface.class,
				NematodeTrackingPanelViewController.class);
	}

	@Test
	public void testGetsNematodeTrackingPanel() throws Exception {
		final NematodeTrackingPanelViewController nematodeTrackingPanelViewController = new NematodeTrackingPanelViewController(
				new MockVideoFrameHandler());

		assertIsOfTypeAndGet(NematodeTrackingPanel.class,
				nematodeTrackingPanelViewController.getNematodePanel());
	}

	@Test
	public void testGetsNematodeVideoFrame() throws Exception {
		final MockVideoFrameHandler expectedFrameHandler = new MockVideoFrameHandler();
		final NematodeTrackingPanelViewController viewController = new NematodeTrackingPanelViewController(
				expectedFrameHandler);
		assertSame(expectedFrameHandler, viewController.getVideoFrameHandler());
	}

	@Test
	public void testConstructorAddsListener_ScanImageButtonOnPanel()
			throws Exception {
		final NematodeTrackingPanelViewController viewController = new NematodeTrackingPanelViewController(
				new MockVideoFrameHandler());
		final NematodeTrackingPanel trackingPanel = assertIsOfTypeAndGet(
				NematodeTrackingPanel.class, viewController.getNematodePanel());
		final JButton scanButton = trackingPanel.getScanButton();
		assertEquals(1, scanButton.getActionListeners().length);
		final ScanImageButtonActionListener buttonActionListener = assertIsOfTypeAndGet(
				ScanImageButtonActionListener.class,
				scanButton.getActionListeners()[0]);
		final NematodePanelViewControllerInterface actualViewController = buttonActionListener
				.getPanelViewController();
		assertSame(viewController, actualViewController);
	}

	@Test
	public void testUpdateImageCallsScan_AndUpdateDisplayImage_OnFrameHandler()
			throws Exception {

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

		final NematodeTrackingPanelViewController viewController = new NematodeTrackingPanelViewController(
				mockHandler);

		assertFalse(mockHandler.wasScanImageCalled());
		assertFalse(mockHandler.wasUpdateDisplayImageFromScannedImageCalled());
		viewController.updateImage();
		assertTrue(mockHandler.wasScanImageCalled());
		assertTrue(mockHandler.wasUpdateDisplayImageFromScannedImageCalled());

	}
}