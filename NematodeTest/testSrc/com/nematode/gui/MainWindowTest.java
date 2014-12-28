package com.nematode.gui;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

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

		assertEquals(JFrame.EXIT_ON_CLOSE, mainWindow.getDefaultCloseOperation());

		assertEquals(GuiConstants.VIDEO_FRAME_HEIGHT, mainWindow.getHeight());
		assertEquals(GuiConstants.VIDEO_FRAME_WIDTH, mainWindow.getWidth());
		assertTrue(mainWindow.isResizable());

		final Container contentPane = mainWindow.getContentPane();
		assertIsOfTypeAndGet(GridBagLayout.class, contentPane.getLayout());

		mainWindow.dispose();
	}

	@Test
	public void testConstructorCorrectlySetsUpContentPane() throws Exception {
		final BufferedImage expectedBackgroundImage = ImageIO.read(new File(
				GuiConstants.MAIN_WINDOW_BACKGROUND_IMAGE_PATH));

		final MainWindow mainWindow = new MainWindow();

		final ImagePanel imageContentPane = assertIsOfTypeAndGet(ImagePanel.class,
				mainWindow.getContentPane());

		assertImagesAreEqual(expectedBackgroundImage, imageContentPane.getImage());
	}
}
