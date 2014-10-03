package com.nematode.imaging;

import com.nematode.model.NematodeVideoFrameInterface;

public class MockImageProcessingRunner implements
		ImageProcessingRunnerInterface {

	private boolean preprocessImageForScanningWasCalled = false;
	private NematodeVideoFrameInterface unprocessedVideoFrame;

	@Override
	public void preprocessImageForScanning(
			final NematodeVideoFrameInterface videoFrame) {
		this.unprocessedVideoFrame = videoFrame;
		this.preprocessImageForScanningWasCalled = true;
	}

	public boolean wasPreprocessImageForScanningCalled() {
		return this.preprocessImageForScanningWasCalled;
	}

	public NematodeVideoFrameInterface getUnprocessedVideoFrame() {
		return this.unprocessedVideoFrame;
	}
}
