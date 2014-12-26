package com.nematode.image.processing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageResizer implements ImageResizerInterface {

	@Override
	public BufferedImage resizeImage(final BufferedImage image, final int width, final int height) {
		final BufferedImage resizedImage = new BufferedImage(width, height, image.getType());

		final Graphics graphics = resizedImage.getGraphics();

		final int startingXCoordinate = 0;
		final int startingYCoordinate = 0;

		graphics.drawImage(image, startingXCoordinate, startingYCoordinate, width, height, null);

		graphics.dispose();

		return resizedImage;
	}

	@Override
	public BufferedImage resizeImageWithAspect(final BufferedImage image, final int width,
			final int height) {
		final double originalRatio = (double) image.getWidth() / image.getHeight();
		final double newRatio = (double) width / height;

		if (originalRatio > newRatio) {
			final int newHeight = (int) (width / originalRatio);
			return resizeImage(image, width, newHeight);
		} else {
			final int newHeight = (int) (height * originalRatio);
			return resizeImage(image, newHeight, height);
		}
	}
}
