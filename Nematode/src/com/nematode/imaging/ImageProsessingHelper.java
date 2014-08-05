package com.nematode.imaging;

import java.awt.image.BufferedImage;

public class ImageProsessingHelper {

	public BufferedImage convertImageToGrayScale(final BufferedImage inputImage) {
		final BufferedImage greyScaleImage = new BufferedImage(
				inputImage.getWidth(), inputImage.getHeight(),
				BufferedImage.TYPE_BYTE_GRAY);

		greyScaleImage.getGraphics().drawImage(inputImage, 0, 0, null);

		return greyScaleImage;

	}
}
