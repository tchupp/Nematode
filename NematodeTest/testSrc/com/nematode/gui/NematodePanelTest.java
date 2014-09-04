package com.nematode.gui;

import javax.swing.JPanel;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodePanelTest extends AssertTestCase {

	@Test
	public void testExtendsJPanel() throws Exception {
		assertExtends(JPanel.class, NematodePanel.class);
	}

}
