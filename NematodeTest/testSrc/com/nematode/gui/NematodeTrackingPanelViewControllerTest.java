package com.nematode.gui;

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
		final NematodeTrackingPanelViewController nematodeTrackingPanelViewController = new NematodeTrackingPanelViewController();

		assertIsOfTypeAndGet(NematodeTrackingPanel.class,
				nematodeTrackingPanelViewController.getNematodePanel());
	}
}
