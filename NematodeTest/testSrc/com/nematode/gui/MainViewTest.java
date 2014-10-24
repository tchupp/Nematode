package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.WindowConstants;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class MainViewTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final MainView mainView = new MainView();
		assertExtends(ExtendableJFrame.class, mainView.getClass());

		mainView.dispose();
	}

	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		final MainView mainView = new MainView();

		assertEquals(WindowConstants.EXIT_ON_CLOSE,
				mainView.getDefaultCloseOperation());

		final Container contentPane = mainView.getContentPane();
		assertIsOfTypeAndGet(BorderLayout.class, contentPane.getLayout());
		assertEquals(MainView.FRAME_HEIGHT,
				mainView.getHeight());
		assertEquals(MainView.FRAME_WIDTH, mainView.getWidth());
		assertTrue(mainView.isResizable());

		mainView.dispose();
	}

	@Test
	public void testFrameWidthAndHeightConstants() throws Exception {
		assertEquals(1920, MainView.FRAME_WIDTH);
		assertEquals(1080, MainView.FRAME_HEIGHT);
	}
}