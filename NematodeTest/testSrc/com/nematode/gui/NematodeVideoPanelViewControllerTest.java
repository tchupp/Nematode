package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testGetsNematodeVideoPanel() throws Exception {
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController();

		assertIsOfTypeAndGet(NematodeVideoPanel.class,
				nematodeVideoPanelViewController.getNematodeVideoPanel());
	}

}
