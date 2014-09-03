package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeProjectPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testGetsNematodeProjectPanel() throws Exception {
		final NematodeProjectPanelViewController nematodeProjectViewController = new NematodeProjectPanelViewController();

		assertIsOfTypeAndGet(NematodeProjectPanel.class,
				nematodeProjectViewController.getNematodeProjectPanel());
	}
}
