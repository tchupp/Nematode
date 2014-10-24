package com.nematode.image.processing;

import java.awt.image.BufferedImage;

import com.nematode.image.BlackAndWhiteImage;
import com.nematode.image.GreyScaleImage;
import com.nematode.image.ProcessedFrameImage;
import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.model.VideoFrameInterface;

public class ImageProcessingRunner implements ImageProcessingRunnerInterface {

	private final ImageProcessingHelperInterface imageProcessingHelper;

	public ImageProcessingRunner(
			final ImageProcessingHelperInterface imageProcessingHelper) {
		this.imageProcessingHelper = imageProcessingHelper;
	}

	@Override
	public ProcessedFrameImageInterface preprocessImageForScanning(
			final VideoFrameInterface videoFrame) {
		final BufferedImage preprocessedImage = videoFrame.getVideoFrameImage()
				.getImage();

		final GreyScaleImage greyScaleImage = this.imageProcessingHelper
				.convertImageToGreyScale(preprocessedImage);
		final BlackAndWhiteImage blackAndWhiteImage = this.imageProcessingHelper
				.convertImageToBlackAndWhite(greyScaleImage, 230f);

		return new ProcessedFrameImage(blackAndWhiteImage);
	}

	@Override
	public BlackAndWhiteImage createImageWithIdentifiedObjects(
			final VideoFrameInterface videoFrame) {
		final BlackAndWhiteImage imageWithDrawnObjects = this.imageProcessingHelper
				.drawObjectsOnNewImage(videoFrame.getVideoFrameImage()
						.getImage(), videoFrame.getObjectsOnImage());

		return imageWithDrawnObjects;
	}

	public ImageProcessingHelperInterface getImageProcessingHelper() {
		return this.imageProcessingHelper;
	}
}
