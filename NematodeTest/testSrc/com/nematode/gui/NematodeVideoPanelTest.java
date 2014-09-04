package com.nematode.gui;

import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		assertExtends(NematodePanel.class, NematodeVideoPanel.class);
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeVideoPanel nematodeVideoPanel = new NematodeVideoPanel();

		assertIsOfTypeAndGet(CompoundBorder.class,
				nematodeVideoPanel.getBorder());
	}
}