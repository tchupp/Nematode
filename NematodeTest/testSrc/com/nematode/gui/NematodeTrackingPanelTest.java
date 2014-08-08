package com.nematode.gui;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeTrackingPanelTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final NematodeTrackingPanel nematodeTrackingPanel = new NematodeTrackingPanel();
		assertExtends(JPanel.class, nematodeTrackingPanel.getClass());
	}

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeTrackingPanel nematodeTrackingPanel = new NematodeTrackingPanel();

		assertIsOfTypeAndGet(CompoundBorder.class,
				nematodeTrackingPanel.getBorder());
	}
}
