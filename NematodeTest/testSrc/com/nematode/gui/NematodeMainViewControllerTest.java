package com.nematode.gui;

import java.awt.Component;
import java.awt.Container;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeMainViewControllerTest extends AssertTestCase {

	@Test
	public void testConstructionAddsPanelsToViewCorrectly() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		final NematodeMainView nematodeMainView = nematodeMainViewController
				.getNematodeMainView();

		final Container contentPane = nematodeMainView.getContentPane();
		final Component[] components = contentPane.getComponents();
		assertEquals(3, components.length);

		assertIsOfTypeAndGet(NematodeProjectPanel.class, components[0]);
		assertIsOfTypeAndGet(NematodeVideoPanel.class, components[1]);
		assertIsOfTypeAndGet(NematodeTrackingPanel.class, components[2]);
	}

	@Test
	public void testGetsNematodeMainView() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		assertIsOfTypeAndGet(NematodeMainView.class,
				nematodeMainViewController.getNematodeMainView());
	}

	@Test
	public void testGetPanelViewControllers() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();

		assertIsOfTypeAndGet(NematodeProjectPanelViewController.class,
				nematodeMainViewController
				.getNematodeProjectPanelViewController());

		assertIsOfTypeAndGet(NematodeTrackingPanelViewController.class,
				nematodeMainViewController
				.getNematodeTrackingPanelViewController());

		assertIsOfTypeAndGet(NematodeVideoPanelViewController.class,
				nematodeMainViewController
				.getNematodeVideoPanelViewController());
	}
}
