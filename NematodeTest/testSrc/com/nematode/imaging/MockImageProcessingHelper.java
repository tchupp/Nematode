package com.nematode.imaging;

import java.awt.image.BufferedImage;

import com.nematode.nullmodel.NullBufferedImage;

public class MockImageProcessingHelper implements
ImageProcessingHelperInterface {

	private boolean convertImageToGreyScaleWasCalled = false;
	private boolean convertImageToBlackAndWhiteWasCalled = false;
	private boolean markDifferencesInImagesInWhiteWasCalled = false;
	private boolean overlayImageWasCalled = false;
	private BufferedImage baseImageToOverlay;
	private BufferedImage topImageToOverlay;

	@Override
	public GreyScaleImage convertImageToGreyScale(final BufferedImage inputImage) {
		this.convertImageToGreyScaleWasCalled = true;
		return new GreyScaleImage(new NullBufferedImage());
	}

	public boolean wasConvertImageToGreyScaleCalled() {
		return this.convertImageToGreyScaleWasCalled;
	}

	@Override
	public BlackAndWhiteImage convertImageToBlackAndWhite(
			final GreyScaleImage inputImage, final double toleranceSeperator) {
		this.convertImageToBlackAndWhiteWasCalled = true;

		return new BlackAndWhiteImage(new NullBufferedImage());
	}

	public boolean wasConvertImageToBlackAndWhiteCalled() {
		return this.convertImageToBlackAndWhiteWasCalled;
	}

	@Override
	public BufferedImage markDifferencesInImagesInWhite(
			final BufferedImage originalImage, final BufferedImage updatedImage) {
		this.markDifferencesInImagesInWhiteWasCalled = true;
		return new NullBufferedImage();
	}

	public boolean wasMarkDifferencesInImagesInWhiteCalled() {
		return this.markDifferencesInImagesInWhiteWasCalled;
	}

	@Override
	public BufferedImage overlayImage(final BufferedImage baseImage,
			final BufferedImage topImage) {
		this.baseImageToOverlay = baseImage;
		this.topImageToOverlay = topImage;
		this.overlayImageWasCalled = true;
		return new NullBufferedImage();
	}

	public boolean wasOverlayImageCalled() {
		return this.overlayImageWasCalled;
	}

	public BufferedImage getBaseImageToOverlay() {
		return this.baseImageToOverlay;
	}

	public BufferedImage getTopImageToOverlay() {
		return this.topImageToOverlay;
	}
}
