package com.nematode.imaging;

import com.nematode.fileIO.ValidatedImageFileInterface;
import com.nematode.gui.MockNematodeVideoFrame;
import com.nematode.model.NematodeVideoFrameInterface;

public class MockVideoFrameHandler implements VideoFrameHandlerInterface {

	private ValidatedImageFileInterface validatedImageFile;
	private NematodeVideoFrameInterface nematodeVideoFrame = new MockNematodeVideoFrame();
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
	public NematodeVideoFrameInterface getNematodeVideoFrame() {
		return this.nematodeVideoFrame;
	}

	public void setNematodeVideoFrame(
			final NematodeVideoFrameInterface nematodeVideoFrame) {
		this.nematodeVideoFrame = nematodeVideoFrame;
	}

	@Override
	public void updateDisplayImageFromScannedObjects() {
		this.updateDisplayImageFromScannedImageWasCalled = true;
	}

	public boolean wasUpdateDisplayImageFromScannedImageCalled() {
		return this.updateDisplayImageFromScannedImageWasCalled;
	}
}
