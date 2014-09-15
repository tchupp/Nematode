package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.WindowConstants;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeMainViewTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final NematodeMainView nematodeMainView = new NematodeMainView();
		assertExtends(NematodeFrame.class, nematodeMainView.getClass());

		nematodeMainView.dispose();
	}

	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		final NematodeMainView nematodeMainView = new NematodeMainView();

		assertEquals(WindowConstants.EXIT_ON_CLOSE,
				nematodeMainView.getDefaultCloseOperation());

		final Container contentPane = nematodeMainView.getContentPane();
		assertIsOfTypeAndGet(BorderLayout.class, contentPane.getLayout());
		assertEquals(NematodeMainView.FRAME_HEIGHT,
				nematodeMainView.getHeight());
		assertEquals(NematodeMainView.FRAME_WIDTH, nematodeMainView.getWidth());
		assertTrue(nematodeMainView.isResizable());

		nematodeMainView.dispose();
	}

	@Test
	public void testFrameWidthAndHeightConstants() throws Exception {
		assertEquals(1920, NematodeMainView.FRAME_WIDTH);
		assertEquals(1080, NematodeMainView.FRAME_HEIGHT);
	}
}