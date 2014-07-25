package com.nematode.gui;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

public class NematodeVideoContainerPanelTest extends TestCase {

	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		NematodeVideoContainerPanel nematodeVideoContainerPanel = new NematodeVideoContainerPanel();
		assertEquals(Color.CYAN, nematodeVideoContainerPanel.getBackground());
	}

}
