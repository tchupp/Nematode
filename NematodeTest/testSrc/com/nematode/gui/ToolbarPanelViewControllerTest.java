package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ToolbarPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ToolbarPanelViewControllerInterface.class,
				ToolbarPanelViewController.class);
	}

	@Test
	public void testGetsToolbarPanel() throws Exception {
		final ToolbarPanelViewController toolbarPanelViewController = new ToolbarPanelViewController();

		assertIsOfTypeAndGet(ToolbarPanel.class, toolbarPanelViewController.getToolbarPanel());
	}

}
