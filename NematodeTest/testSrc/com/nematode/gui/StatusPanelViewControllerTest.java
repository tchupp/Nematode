package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class StatusPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(StatusPanelViewControllerInterface.class,
				StatusPanelViewController.class);
	}

	@Test
	public void testGetsStatusPanel() throws Exception {
		final StatusPanelViewController statusPanelViewController = new StatusPanelViewController();

		assertIsOfTypeAndGet(StatusPanel.class, statusPanelViewController.getStatusPanel());
	}

}
