package com.nematode.gui;

import org.junit.Test;

import com.nematode.image.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class ImagePanelTest extends AssertTestCase {

	@Test
	public void testExtendsExtendableJPanel() throws Exception {
		assertExtends(ExtendableJPanel.class, ImagePanel.class);
	}

	@Test
	public void testGetsBufferedImagePassedIn() throws Exception {
		final NullBufferedImage expectedImage = new NullBufferedImage();
		final ImagePanel imagePanel = new ImagePanel(expectedImage);

		assertSame(expectedImage, imagePanel.getImage());
	}

	@Test
	public void testPaintComponentIsOverridenToPaintImageOnGraphics() throws Exception {
		final MockGraphics mockGraphics = new MockGraphics();

		final NullBufferedImage expectedImage = new NullBufferedImage();
		final ImagePanel imagePanel = new ImagePanel(expectedImage);

		assertFalse(mockGraphics.wasDrawImageCalled());

		imagePanel.paintComponent(mockGraphics);

		assertTrue(mockGraphics.wasDrawImageCalled());
		assertEquals(0, mockGraphics.getXPosToDraw());
		assertEquals(0, mockGraphics.getYPosToDraw());
		assertEquals(expectedImage, mockGraphics.getImageToDraw());
		assertNull(mockGraphics.getImageObserverToUse());
	}
}
