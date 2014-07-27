package com.nematode.gui;

import javax.swing.JPanel;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeTrackingPanelTest extends AssertTestCase {

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeTrackingPanel nematodeTrackingPanel = new NematodeTrackingPanel();
		assertExtends(JPanel.class, nematodeTrackingPanel.getClass());
	}
}
