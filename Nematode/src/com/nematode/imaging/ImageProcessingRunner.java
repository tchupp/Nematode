package com.nematode.imaging;

import java.awt.image.BufferedImage;

import com.nematode.model.NematodeVideoFrameInterface;

public class ImageProcessingRunner implements ImageProcessingRunnerInterface {

	private final ImageProcessingHelperInterface imageProcessingHelper;

	public ImageProcessingRunner(
			final ImageProcessingHelperInterface imageProcessingHelper) {
		this.imageProcessingHelper = imageProcessingHelper;
	}

	@Override
	public void preprocessImageForScanning(
			final NematodeVideoFrameInterface videoFrame) {
		final BufferedImage preprocessedImage = videoFrame.getVideoFrameImage()
				.getImage();

		final GreyScaleImage greyScaleImage = this.imageProcessingHelper
				.convertImageToGreyScale(preprocessedImage);
		final BlackAndWhiteImage blackAndWhiteImage = this.imageProcessingHelper
				.convertImageToBlackAndWhite(greyScaleImage, 230f);

		videoFrame.setProcessedFrameImage(new ProcessedFrameImage(
				blackAndWhiteImage));
	}

	public ImageProcessingHelperInterface getImageProcessingHelper() {
		return this.imageProcessingHelper;
	}
}
