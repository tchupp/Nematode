package com.nematode.image;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.gui.MockVideoFrame;
import com.nematode.model.VideoFrameInterface;
import com.nematode.model.VideoFrameHandlerInterface;

public class MockVideoFrameHandler implements VideoFrameHandlerInterface {

	private ValidatedImageFileInterface validatedImageFile;
	private VideoFrameInterface videoFrame = new MockVideoFrame();
	private boolean buildVideoFrameWasCalled = false;
	private boolean scanImageWasCalled = false;
	private boolean updateDisplayImageFromScannedImageWasCalled = false;

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

	@Override
	public VideoFrameInterface getVideoFrame() {
		return this.videoFrame;
	}

	public void setVideoFrame(
			final VideoFrameInterface videoFrame) {
		this.videoFrame = videoFrame;
	}

	@Override
	public void updateDisplayImageFromScannedObjects() {
		this.updateDisplayImageFromScannedImageWasCalled = true;
	}

	public boolean wasUpdateDisplayImageFromScannedImageCalled() {
		return this.updateDisplayImageFromScannedImageWasCalled;
	}
}
