package com.nematode.image;

import java.awt.image.BufferedImage;

import com.nematode.image.DisplayFrameImageInterface;
import com.nematode.image.VideoFrameImageInterface;
import com.nematode.model.factory.FrameImageAssemblerInterface;
import com.nematode.nullmodel.NullFrameImage;

public class MockFrameImageAssembler implements FrameImageAssemblerInterface {

	private boolean createDisplayFrameImageWasCalled;
	private boolean createVideoFrameImageWasCalled;
	private BufferedImage displayImageToCreate;
	private DisplayFrameImageInterface displayImageToReturn;

	@Override
	public DisplayFrameImageInterface createDisplayFrameImage(final BufferedImage image) {
		this.displayImageToCreate = image;
		this.createDisplayFrameImageWasCalled = true;

		return this.displayImageToReturn;
	}

	public BufferedImage getDisplayImageToCreate() {
		return this.displayImageToCreate;
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
