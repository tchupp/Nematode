package com.nematode.imaging;

import com.nematode.model.NematodeVideoFrameInterface;

public class MockImageProcessingRunner implements
		ImageProcessingRunnerInterface {

	private boolean preprocessImageForScanningWasCalled = false;
	private boolean scanVideoFrameWasCalled = false;
	private NematodeVideoFrameInterface videoFrameFromScan;
	private ImageProcessingHelperInterface imageProcessingHelper = new MockImageProcessingHelper();

	@Override
	public void preprocessImageForScanning(NematodeVideoFrameInterface videoFrame) {
		this.preprocessImageForScanningWasCalled = true;
	}

	public boolean wasPreprocessImageForScanningCalled() {
		return this.preprocessImageForScanningWasCalled;
	}

	@Override
	public void scanVideoFrame(final NematodeVideoFrameInterface videoFrame) {
		this.videoFrameFromScan = videoFrame;
		this.scanVideoFrameWasCalled = true;
	}

	public NematodeVideoFrameInterface getVideoFrameFromScan() {
		return this.videoFrameFromScan;
	}

	public boolean wasScanVideoFrameCalled() {
		return this.scanVideoFrameWasCalled;
	}

	@Override
	public ImageProcessingHelperInterface getImageProcessingHelper() {
		return this.imageProcessingHelper;
	}

	public void setImageProcessingHelper(
			final ImageProcessingHelperInterface imageProcessingHelper) {
		this.imageProcessingHelper = imageProcessingHelper;
	}
}
