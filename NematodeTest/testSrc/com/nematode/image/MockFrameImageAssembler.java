package com.nematode.image;

import java.awt.image.BufferedImage;

import com.nematode.model.factory.FrameImageAssemblerInterface;

public class MockFrameImageAssembler implements FrameImageAssemblerInterface {

	private boolean createDisplayFrameImageWasCalled;
	private int createDisplayFrameImageCalledCount = 0;
	private boolean createVideoFrameImageWasCalled;
	private int createVideoFrameImageCalledCount = 0;
	private BufferedImage displayImageToUse;
	private DisplayFrameImageInterface displayImageToReturn;
	private BufferedImage videoImageToUse;
	private VideoFrameImageInterface videoImageToReturn;

	@Override
	public DisplayFrameImageInterface createDisplayFrameImage(final BufferedImage image) {
		this.displayImageToUse = image;
		this.createDisplayFrameImageWasCalled = true;
		this.createDisplayFrameImageCalledCount++;

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

	public int getCreateDisplayFrameImageCalledCount() {
		return this.createDisplayFrameImageCalledCount;
	}

	@Override
	public VideoFrameImageInterface createVideoFrameImage(final BufferedImage image) {
		this.videoImageToUse = image;
		this.createVideoFrameImageWasCalled = true;
		this.createVideoFrameImageCalledCount++;

		return this.videoImageToReturn;
	}

	public BufferedImage getVideoImageToUse() {
		return this.videoImageToUse;
	}

	public void setVideoImageToReturn(final VideoFrameImageInterface videoImageToReturn) {
		this.videoImageToReturn = videoImageToReturn;
	}

	public boolean wasCreateVideoFrameImageCalled() {
		return this.createVideoFrameImageWasCalled;
	}

	public int getCreateVideoFrameImageCalledCount() {
		return this.createVideoFrameImageCalledCount;
	}

}
