package com.nematode.imaging;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ImageProcessingHelperTest extends AssertTestCase {

	private BufferedImage bufferedShadesOfBlue;
	private BufferedImage bufferedShadesOfGrey;
	private BufferedImage bufferedShadesOfBlackAndWhite;
	private BufferedImage bufferedShadesOfColor;
	private BufferedImage bufferedShadesToOverlay;
	private BufferedImage bufferedShadesFromOverlay;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		final File shadesOfBlue = new File(
				"testResources/Images/pngOfThe7ShadesOfBlue.png");
		this.bufferedShadesOfBlue = ImageIO.read(shadesOfBlue);

		final File shadesOfGrey = new File(
				"testResources/Images/pngOfThe7ShadesOfGrey.png");
		this.bufferedShadesOfGrey = ImageIO.read(shadesOfGrey);

		final File shadesOfBlackAndWhite = new File(
				"testResources/Images/expectedShadesOfBlackAndWhite.png");
		this.bufferedShadesOfBlackAndWhite = ImageIO
				.read(shadesOfBlackAndWhite);

		final File shadesOfColor = new File(
				"testResources/Images/pngColorfulImageToBlur.png");
		this.bufferedShadesOfColor = ImageIO.read(shadesOfColor);

		final File shadesToOverlay = new File(
				"testResources/Images/pngColorfulToBW.png");
		this.bufferedShadesToOverlay = ImageIO.read(shadesToOverlay);

		final File shadesFromOverlay = new File(
				"testResources/Images/expectedShadesFromOverlay.png");
		this.bufferedShadesFromOverlay = ImageIO.read(shadesFromOverlay);
	}

	@Override
	protected void tearDown() throws Exception {
		this.bufferedShadesOfBlue.flush();
		this.bufferedShadesOfGrey.flush();
		this.bufferedShadesOfBlackAndWhite.flush();
		this.bufferedShadesOfColor.flush();
		this.bufferedShadesToOverlay.flush();
		this.bufferedShadesFromOverlay.flush();
		super.tearDown();
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ImageProcessingHelperInterface.class,
				ImageProcessingHelper.class);
	}

	@Test
	public void testConvertsImageToGreyScale() throws Exception {
		final ImageProcessingHelper imageProcessingHelper = new ImageProcessingHelper();
		final GreyScaleImage convertedImage = imageProcessingHelper
				.convertImageToGreyScale(this.bufferedShadesOfBlue);

		assertImagesAreIdentical(this.bufferedShadesOfGrey, convertedImage);
	}

	@Test
	public void testConvertImageToBlackAndWhite() throws Exception {
		final ImageProcessingHelper imageProcessingHelper = new ImageProcessingHelper();
		final GreyScaleImage greyScaleImage = new GreyScaleImage(
				this.bufferedShadesOfGrey);
		final BlackAndWhiteImage convertedImage = imageProcessingHelper
				.convertImageToBlackAndWhite(greyScaleImage, 128f);

		assertImagesAreIdentical(this.bufferedShadesOfBlackAndWhite,
				convertedImage);
	}

	@Test
	public void testSubtractImageConvertsEqualImagesToAllBlack()
			throws Exception {
		final ImageProcessingHelper imageProcessingHelper = new ImageProcessingHelper();
		final BufferedImage subtractedImages = imageProcessingHelper
				.markDifferencesInImagesInWhite(this.bufferedShadesOfGrey,
						this.bufferedShadesOfGrey);

		assertImageIsAllSpecifiedColor(subtractedImages, Color.black);
	}

	@Test
	public void testOverlayImageColorsTheCorrectPartsOfTheImage()
			throws Exception {
		final ImageProcessingHelper imageProcessingHelper = new ImageProcessingHelper();

		final BufferedImage overlayImage = imageProcessingHelper.overlayImage(
				this.bufferedShadesOfColor, this.bufferedShadesToOverlay);

		assertImagesAreIdentical(this.bufferedShadesFromOverlay, overlayImage);
	}

	@Test
	public void testRemoveObjectsFromImageReturnsImageWithoutObject()
			throws Exception {
		fail("unimplemented");
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