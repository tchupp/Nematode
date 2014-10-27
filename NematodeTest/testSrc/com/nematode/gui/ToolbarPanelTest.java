package com.nematode.gui;

import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ToolbarPanelTest extends AssertTestCase {

	@Test
	public void testExtendableJFrame() throws Exception {
		assertExtends(ExtendableJPanel.class, ToolbarPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final ToolbarPanel toolbarPanel = new ToolbarPanel();

		assertEquals("toolbarPanel", toolbarPanel.getName());

		assertEquals(0, toolbarPanel.getComponentCount());
		assertIsOfTypeAndGet(CompoundBorder.class, toolbarPanel.getBorder());
	}
}
