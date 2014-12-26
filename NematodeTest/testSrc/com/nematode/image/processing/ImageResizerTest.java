package com.nematode.image.processing;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.nematode.image.NullBufferedImage;
import com.nematode.unittesting.AssertTestCase;

public class ImageResizerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ImageResizerInterface.class, ImageResizer.class);
	}

	@Test
	public void testResizeImageChangesImageHeightAndWidthToSpecified() throws Exception {
		final ImageResizer imageResizer = new ImageResizer();
		final BufferedImage originalImage = new NullBufferedImage();
		final int expectedHeight = 900;
		final int expectedWidth = 1200;
		final BufferedImage resizedImage = imageResizer.resizeImage(originalImage, expectedWidth,
				expectedHeight);

		assertEquals(expectedHeight, resizedImage.getHeight());
		assertEquals(expectedWidth, resizedImage.getWidth());
	}

	@Test
	public void testResizeImageMaintainsImageType() throws Exception {
		final ImageResizer imageResizer = new ImageResizer();

		final int expectedTypeOne = BufferedImage.TYPE_INT_ARGB;
		final BufferedImage originalImageOne = new BufferedImage(1, 1, expectedTypeOne);
		final int expectedTypeTwo = BufferedImage.TYPE_BYTE_BINARY;
		final BufferedImage originalImageTwo = new BufferedImage(1, 1, expectedTypeTwo);

		final int expectedHeight = 900;
		final int expectedWidth = 1200;

		final BufferedImage resizedImageOne = imageResizer.resizeImage(originalImageOne,
				expectedWidth, expectedHeight);
		final BufferedImage resizedImageTwo = imageResizer.resizeImage(originalImageTwo,
				expectedWidth, expectedHeight);

		assertEquals(expectedTypeOne, resizedImageOne.getType());
		assertEquals(expectedTypeTwo, resizedImageTwo.getType());
	}

	@Test
	public void testResizeImageWithRealImage() throws Exception {
		final BufferedImage inputImage = ImageIO.read(new File("testResources/Images/testPNG.png"));

		final BufferedImage expectedImage = ImageIO.read(new File(
				"testResources/Images/testPNGResized.png"));

		final ImageResizer imageResizer = new ImageResizer();

		final BufferedImage actualImage = imageResizer.resizeImage(inputImage, 1000, 600);

		final int width = actualImage.getWidth();
		final int height = actualImage.getHeight();

		final int[] expectedRGB = expectedImage.getRGB(0, 0, width, height, null, 0, width);
		final int[] actualRGB = actualImage.getRGB(0, 0, width, height, null, 0, width);

		assertEquals(expectedRGB, actualRGB);
	}

	@Test
	public void testResizeImageWithAspectMaintainsImageType() throws Exception {
		final ImageResizer imageResizer = new ImageResizer();

		final int expectedTypeOne = BufferedImage.TYPE_INT_ARGB;
		final BufferedImage originalImageOne = new BufferedImage(1, 1, expectedTypeOne);
		final int expectedTypeTwo = BufferedImage.TYPE_BYTE_BINARY;
		final BufferedImage originalImageTwo = new BufferedImage(1, 1, expectedTypeTwo);

		final int expectedHeight = 600;
		final int expectedWidth = 1000;

		final BufferedImage resizedImageOne = imageResizer.resizeImageWithAspect(originalImageOne,
				expectedWidth, expectedHeight);
		final BufferedImage resizedImageTwo = imageResizer.resizeImageWithAspect(originalImageTwo,
				expectedWidth, expectedHeight);

		assertEquals(expectedTypeOne, resizedImageOne.getType());
		assertEquals(expectedTypeTwo, resizedImageTwo.getType());
	}

	@Test
	public void testResizeImageWithAspect_RealImage_HigherWidth() throws Exception {
		final BufferedImage inputImage = ImageIO.read(new File("testResources/Images/testPNG.png"));

		final BufferedImage expectedImage = ImageIO.read(new File(
				"testResources/Images/testPNGResized_Width.png"));

		final ImageResizer imageResizer = new ImageResizer();

		final BufferedImage actualImage = imageResizer.resizeImageWithAspect(inputImage, 1100, 600);

		final int width = actualImage.getWidth();
		final int height = actualImage.getHeight();

		final int[] expectedRGB = expectedImage.getRGB(0, 0, width, height, null, 0, width);
		final int[] actualRGB = actualImage.getRGB(0, 0, width, height, null, 0, width);

		assertEquals(expectedRGB, actualRGB);
	}

	@Test
	public void testResizeImageWithAspect_RealImage_HigherHeight() throws Exception {
		final BufferedImage inputImage = ImageIO.read(new File("testResources/Images/testPNG.png"));

		final BufferedImage expectedImage = ImageIO.read(new File(
				"testResources/Images/testPNGResized_Height.png"));

		final ImageResizer imageResizer = new ImageResizer();

		final BufferedImage actualImage = imageResizer.resizeImageWithAspect(inputImage, 1000, 700);

		final int width = actualImage.getWidth();
		final int height = actualImage.getHeight();

		final int[] expectedRGB = expectedImage.getRGB(0, 0, width, height, null, 0, width);
		final int[] actualRGB = actualImage.getRGB(0, 0, width, height, null, 0, width);

		assertEquals(expectedRGB, actualRGB);
	}
}
