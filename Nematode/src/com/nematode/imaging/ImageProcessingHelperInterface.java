package com.nematode.imaging;

import java.awt.image.BufferedImage;

public interface ImageProcessingHelperInterface {

	public GreyScaleImage convertImageToGreyScale(BufferedImage inputImage);

	public BlackAndWhiteImage convertImageToBlackAndWhite(
			GreyScaleImage inputImage, double toleranceSeperator);

	public BufferedImage markDifferencesInImagesInWhite(
			BufferedImage originalImage, BufferedImage updatedImage);

	public BufferedImage overlayImage(BufferedImage baseImage,
			BufferedImage topImage);

}
