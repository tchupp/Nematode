package com.nematode.imaging;

import java.awt.image.BufferedImage;
import java.util.List;

import com.nematode.model.NematodeWormInterface;

public interface ImageProcessingHelperInterface {

	public GreyScaleImage convertImageToGreyScale(BufferedImage inputImage);

	public BlackAndWhiteImage convertImageToBlackAndWhite(
			GreyScaleImage inputImage, double toleranceSeperator);

	public BufferedImage markDifferencesInImagesInWhite(
			BufferedImage originalImage, BufferedImage updatedImage);

	public BufferedImage overlayImage(final BufferedImage baseImage,
			final BufferedImage topImage);

	public BlackAndWhiteImage removeObjectFromImage(
			BufferedImage originalImage, NematodeWormInterface worm);

	public BlackAndWhiteImage drawObjectsOnNewImage(BufferedImage baseImage,
			List<NematodeWormInterface> objects);

}
