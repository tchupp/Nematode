package com.nematode.imaging;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ImageProsessingHelperTest extends AssertTestCase {

	private BufferedImage bufferedShadesOfBlue;
	private BufferedImage bufferedShadesOfGrey;
	private BufferedImage bufferedShadesOfBlackAndWhite;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		final File shadesOfBlue = new File(
				"testResources/pngOfThe7ShadesOfBlue.png");
		this.bufferedShadesOfBlue = ImageIO.read(shadesOfBlue);

		final File shadesOfGrey = new File(
				"testResources/pngOfThe7ShadesOfGrey.png");
		this.bufferedShadesOfGrey = ImageIO.read(shadesOfGrey);

		final File shadesOfBlackAndWhite = new File(
				"testResources/expectedBitmapOfShadesOfBlackAndWhite.png");
		this.bufferedShadesOfBlackAndWhite = ImageIO
				.read(shadesOfBlackAndWhite);
	}

	@Test
	public void testNoPublicConstructor() throws Exception {
		final Constructor<?>[] constructors = ImageProsessingHelper.class
				.getDeclaredConstructors();
		assertEquals(1, constructors.length);
		assertTrue(Modifier.isPrivate(constructors[0].getModifiers()));
	}

	@Test
	public void testConvertsImageToGreyScale() throws Exception {
		final BufferedImage convertedImage = ImageProsessingHelper
				.convertImageToGreyScale(this.bufferedShadesOfBlue);

		assertImagesAreIdentical(this.bufferedShadesOfGrey, convertedImage);
	}

	@Test
	public void testConvertImageToBlackAndWhite() throws Exception {
		final BufferedImage convertedImage = ImageProsessingHelper
				.convertImageToBlackAndWhite(this.bufferedShadesOfGrey, 0.5f);

		assertImagesAreIdentical(this.bufferedShadesOfBlackAndWhite,
				convertedImage);
	}

	@Test
	public void testSubtractImageConvertsEqualImagesToAllBlack()
			throws Exception {

		final BufferedImage subtractedImages = ImageProsessingHelper
				.markDifferencesInImagesInWhite(this.bufferedShadesOfGrey,
						this.bufferedShadesOfGrey);

		assertImageIsAllSpecifiedColor(subtractedImages, Color.black);
	}

	private void assertImageIsAllSpecifiedColor(final BufferedImage inputImage,
			final Color specifiedColor) {

		final int width = inputImage.getWidth();
		final int height = inputImage.getHeight();
		final int[] inputImageRGB = new int[width * height];

		inputImage.getRGB(0, 0, width, height, inputImageRGB, 0, width);

		for (final int rgb : inputImageRGB) {
			assertEquals(rgb, specifiedColor.getRGB());
		}
	}

	private void assertImagesAreIdentical(final BufferedImage expectedImage,
			final BufferedImage actualImage) {

		final int expectedWidth = expectedImage.getWidth();
		final int expectedHeight = expectedImage.getHeight();
		final int[] expectedImageRGB = new int[expectedWidth * expectedHeight];

		expectedImage.getRGB(0, 0, expectedWidth, expectedHeight,
				expectedImageRGB, 0, expectedWidth);

		final int actualWidth = expectedImage.getWidth();
		final int actualHeight = expectedImage.getHeight();
		final int[] actualImageRGB = new int[actualWidth * actualHeight];

		actualImage.getRGB(0, 0, actualWidth, actualHeight, actualImageRGB, 0,
				actualWidth);

		assertEquals(expectedImageRGB, actualImageRGB);
	}
}