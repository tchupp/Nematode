package com.nematode.image.processing;

import java.awt.image.BufferedImage;

public class MockImageResizer implements ImageResizerInterface {

	private BufferedImage imageWithAspectPassedIn;
	private int widthWithAspect;
	private int heightWithAspect;
	private BufferedImage imageWithAspectToReturn;
	private boolean resizeImageWithAspectWasCalled;

	@Override
	public BufferedImage resizeImage(final BufferedImage image, final int width, final int height) {
		return null;
	}

	@Override
	public BufferedImage resizeImageWithAspect(final BufferedImage image, final int width,
			final int height) {
		this.resizeImageWithAspectWasCalled = true;
		this.imageWithAspectPassedIn = image;
		this.widthWithAspect = width;
		this.heightWithAspect = height;
		return this.imageWithAspectToReturn;
	}

	public boolean wasResizeImageWithAspectCalled() {
		return this.resizeImageWithAspectWasCalled;
	}

	public BufferedImage getImageWithAspectPassedIn() {
		return this.imageWithAspectPassedIn;
	}

	public int getHeightWithAspect() {
		return this.heightWithAspect;
	}

	public int getWidthWithAspect() {
		return this.widthWithAspect;
	}

	public void setImageWithAspectToReturn(final BufferedImage imageWithAspectToReturn) {
		this.imageWithAspectToReturn = imageWithAspectToReturn;
	}

}
