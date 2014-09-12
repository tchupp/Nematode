package com.nematode.gui;

import javax.swing.JButton;

import org.junit.Test;

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
				new MockNematodeVideoFrame());

		assertIsOfTypeAndGet(NematodeTrackingPanel.class,
				nematodeTrackingPanelViewController.getNematodePanel());
	}

	@Test
	public void testGetsNematodeVideoFrame() throws Exception {
		final MockNematodeVideoFrame expectedVideoFrame = new MockNematodeVideoFrame();
		final NematodeTrackingPanelViewController viewController = new NematodeTrackingPanelViewController(
				expectedVideoFrame);
		assertSame(expectedVideoFrame, viewController.getNematodeVideoFrame());
	}

	@Test
	public void testConstructorAddsListener_ScanImageButtonOnPanel()
			throws Exception {
		final NematodeTrackingPanelViewController viewController = new NematodeTrackingPanelViewController(
				new MockNematodeVideoFrame());
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
	public void testUpdateImageSetsNewDisplayImageOnNematodeVideoFrame()
			throws Exception {
		fail("unimplemented");
	}
}