package com.nematode.imaging;

import java.awt.image.BufferedImage;

import com.nematode.nullmodel.NullFrameImage;

public class MockFrameImageAssembler implements FrameImageAssemblerInterface {

	private boolean createDisplayFrameImageWasCalled;
	private boolean createVideoFrameImageWasCalled;

	@Override
	public DisplayFrameImageInterface createDisplayFrameImage(
			final BufferedImage image) {
		this.createDisplayFrameImageWasCalled = true;

		return NullFrameImage.NULL;
	}

	public boolean wasCreateDisplayFrameImageCalled() {
		return this.createDisplayFrameImageWasCalled;
	}

	@Override
	public VideoFrameImageInterface createVideoFrameImage(
			final BufferedImage image) {
		this.createVideoFrameImageWasCalled = true;
		return NullFrameImage.NULL;
	}

	public boolean wasCreateVideoFrameImageCalled() {
		return this.createVideoFrameImageWasCalled;
	}

}
