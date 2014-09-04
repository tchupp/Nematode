package com.nematode.gui;

import org.junit.Test;

import com.nematode.nullmodel.NullNematodeVideoFrame;
import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodePanelViewControllerInterface.class,
				NematodeVideoPanelViewController.class);
	}

	@Test
	public void testGetsNematodeVideoPanel() throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController();

		assertIsOfTypeAndGet(NematodeVideoPanel.class,
				nematodeVideoPanelViewController.getNematodePanel());
	}

	@Test
	public void testGetVideoFrameReturns_NullVideoFrame_AfterConstruction()
			throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController();
		assertIsOfTypeAndGet(NullNematodeVideoFrame.class,
				nematodeVideoPanelViewController.getNematodeVideoFrame());
	}
}
