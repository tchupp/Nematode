package com.nematode.imaging;

import com.nematode.fileIO.ValidatedImageFileInterface;

public class MockVideoFrameHandler implements VideoFrameHandlerInterface {

	private ValidatedImageFileInterface validatedImageFile;
	private boolean buildVideoFrameWasCalled = false;
	private boolean scanImageWasCalled = false;

	@Override
	public void buildNewFrameImageFromFile(
			final ValidatedImageFileInterface imageFile) {
		this.validatedImageFile = imageFile;
		this.buildVideoFrameWasCalled = true;
	}

	public boolean wasBuildVideoFrameCalled() {
		return this.buildVideoFrameWasCalled;
	}

	public ValidatedImageFileInterface getValidatedImageFile() {
		return this.validatedImageFile;
	}

	@Override
	public void scanImage() {
		this.scanImageWasCalled = true;
	}

	public boolean wasScanImageCalled() {
		return this.scanImageWasCalled;
	}

}
