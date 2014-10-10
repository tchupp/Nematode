package com.nematode.imaging;

import com.nematode.model.NematodeVideoFrameInterface;

public class MockImageProcessingRunner implements
		ImageProcessingRunnerInterface {

	private boolean preprocessImageForScanningWasCalled = false;
	private boolean createImageWithIdentifiedObjectsWasCalled = false;
	private NematodeVideoFrameInterface unprocessedVideoFrame;
	private ProcessedFrameImageInterface processedImageToReturn;
	private NematodeVideoFrameInterface videoFrameDrawn;
	private BlackAndWhiteImage imageWithObjectsToReturn;

	@Override
	public ProcessedFrameImageInterface preprocessImageForScanning(
			final NematodeVideoFrameInterface videoFrame) {
		this.unprocessedVideoFrame = videoFrame;
		this.preprocessImageForScanningWasCalled = true;
		return this.processedImageToReturn;
	}

	public void setProcessedImageToReturn(
			final ProcessedFrameImageInterface processedImageToReturn) {
		this.processedImageToReturn = processedImageToReturn;
	}

	public boolean wasPreprocessImageForScanningCalled() {
		return this.preprocessImageForScanningWasCalled;
	}

	public NematodeVideoFrameInterface getUnprocessedVideoFrame() {
		return this.unprocessedVideoFrame;
	}

	@Override
	public BlackAndWhiteImage createImageWithIdentifiedObjects(
			final NematodeVideoFrameInterface videoFrame) {
		this.videoFrameDrawn = videoFrame;
		this.createImageWithIdentifiedObjectsWasCalled = true;
		return this.imageWithObjectsToReturn;
	}

	public void setImageWithObjectsToReturn(
			final BlackAndWhiteImage imageWithObjectsToReturn) {
		this.imageWithObjectsToReturn = imageWithObjectsToReturn;
	}

	public boolean wasCreateImageWithIdentifiedObjectsCalled() {
		return this.createImageWithIdentifiedObjectsWasCalled;
	}

	public NematodeVideoFrameInterface getVideoFrameDrawn() {
		return this.videoFrameDrawn;
	}
}
