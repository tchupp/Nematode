package com.nematode.imaging;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageProcessingHelper {

	private ImageProcessingHelper() {
	}

	public static BufferedImage convertImageToGreyScale(
			final BufferedImage inputImage) {
		final BufferedImage greyScaleImage = new BufferedImage(
				inputImage.getWidth(), inputImage.getHeight(),
				BufferedImage.TYPE_BYTE_GRAY);

		final Graphics graphics = greyScaleImage.getGraphics();
		graphics.drawImage(inputImage, 0, 0, null);
		graphics.dispose();

		return greyScaleImage;
	}

	public static BufferedImage convertImageToBlackAndWhite(
			final BufferedImage inputImage, final float toleranceSeperator) {
		final int width = inputImage.getWidth();
		final int height = inputImage.getHeight();
		final int[] inputImageRGB = new int[width * height];
		final int[] outputImageRGB = new int[width * height];

		inputImage.getRGB(0, 0, width, height, inputImageRGB, 0, width);

		for (int i = 0; i < inputImageRGB.length; i++) {
			final HSBColor hsbColor = new HSBColor(inputImageRGB[i]);
			if (hsbColor.getBrightness() > toleranceSeperator) {
				outputImageRGB[i] = Color.WHITE.getRGB();
			} else {
				outputImageRGB[i] = Color.BLACK.getRGB();
			}
		}

		final BufferedImage outputImage = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_BINARY);

		outputImage.setRGB(0, 0, width, height, outputImageRGB, 0, width);

		return outputImage;
	}

	public static BufferedImage markDifferencesInImagesInWhite(
			final BufferedImage originalImage, final BufferedImage updatedImage) {
		final int width = originalImage.getWidth();
		final int height = originalImage.getHeight();

		final int[] originalImageRGB = new int[width * height];
		final int[] updatedImageRGB = new int[width * height];
		final int[] binaryOutputImageRGB = new int[width * height];

		originalImage.getRGB(0, 0, width, height, originalImageRGB, 0, width);
		updatedImage.getRGB(0, 0, width, height, updatedImageRGB, 0, width);

		for (int i = 0; i < updatedImageRGB.length; i++) {
			if (originalImageRGB[i] == updatedImageRGB[i]) {
				binaryOutputImageRGB[i] = Color.black.getRGB();
			} else {
				binaryOutputImageRGB[i] = Color.white.getRGB();
			}
		}

		final BufferedImage binaryOutputImage = new BufferedImage(width,
				height, BufferedImage.TYPE_BYTE_BINARY);

		binaryOutputImage.setRGB(0, 0, width, height, binaryOutputImageRGB, 0,
				width);

		return binaryOutputImage;
	}
}
