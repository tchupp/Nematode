package com.nematode.imaging;

import com.nematode.fileIO.ValidatedImageFileInterface;

public class MockVideoFrameBuilder implements VideoFrameBuilderInterface {

	private ValidatedImageFileInterface validatedImageFile;
	private boolean buildVideoFrameWasCalled = false;

	@Override
	public void buildNewFrameImageFromFile(final ValidatedImageFileInterface imageFile) {
		this.validatedImageFile = imageFile;
		this.buildVideoFrameWasCalled = true;
	}

	public boolean wasBuildVideoFrameCalled() {
		return this.buildVideoFrameWasCalled;
	}

	public ValidatedImageFileInterface getValidatedImageFile() {
		return this.validatedImageFile;
	}

}
