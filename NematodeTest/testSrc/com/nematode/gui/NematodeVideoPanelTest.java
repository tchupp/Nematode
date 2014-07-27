package com.nematode.gui;

import javax.swing.JPanel;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoPanelTest extends AssertTestCase {

	@Test
	public void testConstructorCorrectlySetsUpPanel() throws Exception {
		final NematodeVideoPanel nematodeVideoPanel = new NematodeVideoPanel();
		assertExtends(JPanel.class, nematodeVideoPanel.getClass());
	}

}
