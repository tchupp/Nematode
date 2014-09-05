package com.nematode.gui;

import java.awt.BorderLayout;
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
		assertIsOfTypeAndGet(BorderLayout.class, contentPane.getLayout());
		assertEquals(1000, nematodeMainView.getHeight());
		assertEquals(1500, nematodeMainView.getWidth());
		assertTrue(nematodeMainView.isResizable());
	}
}