package com.nematode.image;

import com.nematode.image.BlackAndWhiteImage;
import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.image.processing.ImageProcessingRunnerInterface;
import com.nematode.model.VideoFrameInterface;

public class MockImageProcessingRunner implements
		ImageProcessingRunnerInterface {

	private boolean preprocessImageForScanningWasCalled = false;
	private boolean createImageWithIdentifiedObjectsWasCalled = false;
	private VideoFrameInterface unprocessedVideoFrame;
	private ProcessedFrameImageInterface processedImageToReturn;
	private VideoFrameInterface videoFrameDrawn;
	private BlackAndWhiteImage imageWithObjectsToReturn;

	@Override
	public ProcessedFrameImageInterface preprocessImageForScanning(
			final VideoFrameInterface videoFrame) {
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

	public VideoFrameInterface getUnprocessedVideoFrame() {
		return this.unprocessedVideoFrame;
	}

	@Override
	public BlackAndWhiteImage createImageWithIdentifiedObjects(
			final VideoFrameInterface videoFrame) {
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

	public VideoFrameInterface getVideoFrameDrawn() {
		return this.videoFrameDrawn;
	}
}
