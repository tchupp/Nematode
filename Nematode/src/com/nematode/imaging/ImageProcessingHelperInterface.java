package com.nematode.imaging;

import java.awt.image.BufferedImage;

public interface ImageProcessingHelperInterface {

	public BufferedImage convertImageToGreyScale(BufferedImage inputImage);

	public BufferedImage convertImageToBlackAndWhite(BufferedImage inputImage,
			double toleranceSeperator);

	public BufferedImage markDifferencesInImagesInWhite(
			BufferedImage originalImage, BufferedImage updatedImage);

}
