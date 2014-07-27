package com.nematode.gui;

import javax.swing.JPanel;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeProjectPanelTest extends AssertTestCase {

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();
		assertExtends(JPanel.class, nematodeProjectPanel.getClass());
	}

}
