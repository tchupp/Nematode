package com.nematode.image;

import java.awt.image.BufferedImage;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.model.factory.FrameImageAssemblerInterface;

public class MockFrameImageAssembler implements FrameImageAssemblerInterface {

	private boolean createDisplayFrameImageWasCalled;
	private boolean createVideoFrameImageWasCalled;
	private BufferedImage displayImageToUse;
	private DisplayFrameImageInterface displayImageToReturn;

	@Override
	public DisplayFrameImageInterface createDisplayFrameImage(final BufferedImage image) {
		this.displayImageToUse = image;
		this.createDisplayFrameImageWasCalled = true;

		return this.displayImageToReturn;
	}

	public BufferedImage getDisplayImageToUse() {
		return this.displayImageToUse;
	}

	public void setDisplayImageToReturn(final DisplayFrameImageInterface displayImageToReturn) {
		this.displayImageToReturn = displayImageToReturn;
	}

	public boolean wasCreateDisplayFrameImageCalled() {
		return this.createDisplayFrameImageWasCalled;
	}

	@Override
	public VideoFrameImageInterface createVideoFrameImage(final BufferedImage image) {
		this.createVideoFrameImageWasCalled = true;
		return NullFrameImage.NULL;
	}

	public boolean wasCreateVideoFrameImageCalled() {
		return this.createVideoFrameImageWasCalled;
	}

}
