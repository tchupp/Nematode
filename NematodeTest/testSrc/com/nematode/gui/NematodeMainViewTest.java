package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeMainViewTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final NematodeMainView nematodeMainView = new NematodeMainView();
		assertExtends(JFrame.class, nematodeMainView.getClass());
	}

	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		final NematodeMainView nematodeMainView = new NematodeMainView();

		assertEquals(WindowConstants.EXIT_ON_CLOSE,
				nematodeMainView.getDefaultCloseOperation());

		final Container contentPane = nematodeMainView.getContentPane();
		final Component[] components = contentPane.getComponents();

		assertEquals(3, components.length);

		assertIsOfTypeAndGet(NematodeProjectPanel.class, components[0]);
		assertIsOfTypeAndGet(NematodeVideoPanel.class, components[1]);
		assertIsOfTypeAndGet(NematodeTrackingPanel.class, components[2]);
		assertIsOfTypeAndGet(BorderLayout.class, nematodeMainView.getLayout());

		assertEquals(800, nematodeMainView.getHeight());
		assertEquals(800, nematodeMainView.getWidth());
		assertTrue(nematodeMainView.isResizable());
	}
}