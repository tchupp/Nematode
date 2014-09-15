package com.nematode.imaging;

public class MockImageProcessingRunner implements
ImageProcessingRunnerInterface {

	private boolean preprocessImageForScanningWasCalled = false;
	private boolean scanVideoFrameWasCalled = false;

	@Override
	public void preprocessImageForScanning() {
		this.preprocessImageForScanningWasCalled = true;
	}

	public boolean wasPreprocessImageForScanningCalled() {
		return this.preprocessImageForScanningWasCalled;
	}

	@Override
	public void scanVideoFrame() {
		this.scanVideoFrameWasCalled = true;
	}

	public boolean wasScanVideoFrameCalled() {
		return this.scanVideoFrameWasCalled;
	}

}
