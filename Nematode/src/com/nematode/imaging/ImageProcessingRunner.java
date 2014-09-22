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
	public void preprocessImageForScanning() {

	}

	@Override
	public void scanVideoFrame(final NematodeVideoFrameInterface videoFrame) {
		final BufferedImage preprocessedImage = videoFrame.getVideoFrameImage()
				.getImage();

		final BufferedImage greyScaleImage = this.imageProcessingHelper
				.convertImageToGreyScale(preprocessedImage);
		final BufferedImage blackAndWhiteImage = this.imageProcessingHelper
				.convertImageToBlackAndWhite(greyScaleImage, 0.5);

		videoFrame.setScannedFrameImage(new ScannedFrameImage(
				blackAndWhiteImage));
	}

	@Override
	public ImageProcessingHelperInterface getImageProcessingHelper() {
		return this.imageProcessingHelper;
	}
}
