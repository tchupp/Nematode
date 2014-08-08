package com.nematode.gui;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final NematodeVideoPanel nematodeVideoPanel = new NematodeVideoPanel();
		assertExtends(JPanel.class, nematodeVideoPanel.getClass());
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeVideoPanel nematodeVideoPanel = new NematodeVideoPanel();

		assertIsOfTypeAndGet(CompoundBorder.class,
				nematodeVideoPanel.getBorder());
	}
}