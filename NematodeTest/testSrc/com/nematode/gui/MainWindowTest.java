package com.nematode.gui;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.WindowConstants;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class MainWindowTest extends AssertTestCase {

	@Test
	public void testExtendsJFrame() throws Exception {
		final MainWindow mainWindow = new MainWindow();
		assertExtends(ExtendableJFrame.class, mainWindow.getClass());

		mainWindow.dispose();
	}

	@Test
	public void testConstructorSetsUpPanelCorrectly() throws Exception {
		final MainWindow mainWindow = new MainWindow();

		assertEquals(WindowConstants.EXIT_ON_CLOSE, mainWindow.getDefaultCloseOperation());

		final Container contentPane = mainWindow.getContentPane();
		assertIsOfTypeAndGet(GridBagLayout.class, contentPane.getLayout());
		assertEquals(MainWindow.FRAME_HEIGHT, mainWindow.getHeight());
		assertEquals(MainWindow.FRAME_WIDTH, mainWindow.getWidth());
		assertTrue(mainWindow.isResizable());

		mainWindow.dispose();
	}

	@Test
	public void testFrameWidthAndHeightConstants() throws Exception {
		assertEquals(1920, MainWindow.FRAME_WIDTH);
		assertEquals(1080, MainWindow.FRAME_HEIGHT);
	}
}
