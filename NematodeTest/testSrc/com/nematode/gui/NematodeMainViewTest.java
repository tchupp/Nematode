package com.nematode.gui;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeMainViewTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final NematodeMainView nematodeMainView = new NematodeMainView();

		assertExtends(JFrame.class, nematodeMainView.getClass());
	}

	@SuppressWarnings("unused")
	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		final NematodeMainView nematodeMainView = new NematodeMainView();
		final Container contentPane = nematodeMainView.getContentPane();
		final Component[] components = contentPane.getComponents();

		assertEquals(3, components.length);

		final NematodeProjectPanel nematodeProjectPanel = assertIsOfTypeAndGet(
				NematodeProjectPanel.class, components[0]);
		final NematodeVideoPanel nematodeVideoPanel = assertIsOfTypeAndGet(
				NematodeVideoPanel.class, components[1]);
		final NematodeTrackingPanel nematodeTrackingPanel = assertIsOfTypeAndGet(
				NematodeTrackingPanel.class, components[2]);

		assertTrue(nematodeMainView.isVisible());
	}
}