package com.nematode.gui;

import java.awt.Component;

import junit.framework.TestCase;

import org.junit.Test;

import com.nematode.gui.mocks.MockVideoContainerPanel;

public class NematodeMainWindowTest extends TestCase {

	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		MockVideoContainerPanel mockVideoContainerPanel = new MockVideoContainerPanel();
		NematodeMainWindow nematodeMainWindow = new NematodeMainWindow(
				mockVideoContainerPanel);

		assertTrue(nematodeMainWindow.isVisible());
		assertEquals("NematodeMainWindow", nematodeMainWindow.getName());

		Component[] components = nematodeMainWindow.getComponents();
		assertEquals(2, components.length);

		assertEquals(VideoContainerPanelInterface.class, components[1]);
	}
}
