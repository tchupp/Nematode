package com.nematode.gui;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

import com.nematode.image.NullBufferedImage;
import com.nematode.image.processing.MockImageResizer;
import com.nematode.unittesting.AssertTestCase;

public class VideoPanelViewControllerTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class);
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoPanelViewControllerInterface.class,
				VideoPanelViewController.class);
	}

	@Test
	public void testGetsNematodeVideoPanel() throws Exception {
		final VideoPanelViewController videoPanelViewController = new VideoPanelViewController(
				new MockImageResizer());

		assertIsOfTypeAndGet(VideoPanel.class, videoPanelViewController.getVideoPanel());
	}

	@Test
	public void testGetsImageResizer() throws Exception {
		final MockImageResizer imageResizer = new MockImageResizer();
		final VideoPanelViewController videoPanelViewController = new VideoPanelViewController(
				imageResizer);

		assertSame(imageResizer, videoPanelViewController.getImageResizer());
	}

	@Test
	public void testShowImageCorrectlyDisplaysImageOnPanel() throws Exception {
		final NullBufferedImage originalImage = new NullBufferedImage();
		final Mat originalMat = Mat.createFrom(originalImage);

		final MockImageResizer imageResizer = new MockImageResizer();
		final NullBufferedImage expectedImage = new NullBufferedImage();
		imageResizer.setImageWithAspectToReturn(expectedImage);

		final VideoPanelViewController viewController = new VideoPanelViewController(imageResizer);

		final VideoPanel videoPanel = assertIsOfTypeAndGet(VideoPanel.class,
				viewController.getVideoPanel());
		final JLabel imageLabel = videoPanel.getImageLabel();
		final ImageIcon imageLabelIconBefore = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());

		final BufferedImage defaultImage = assertIsOfTypeAndGet(BufferedImage.class,
				imageLabelIconBefore.getImage());

		assertNotSame(originalImage, defaultImage);
		assertFalse(imageResizer.wasResizeImageWithAspectCalled());

		viewController.showImage(originalMat);

		assertTrue(imageResizer.wasResizeImageWithAspectCalled());
		assertEquals(GuiConstants.DISPLAY_WIDTH, imageResizer.getWidthWithAspect());
		assertEquals(GuiConstants.DISPLAY_HEIGHT, imageResizer.getHeightWithAspect());

		final ImageIcon imageLabelIconAfter = assertIsOfTypeAndGet(ImageIcon.class,
				imageLabel.getIcon());
		final NullBufferedImage actualImage = assertIsOfTypeAndGet(NullBufferedImage.class,
				imageLabelIconAfter.getImage());

		assertSame(expectedImage, actualImage);
	}
}
