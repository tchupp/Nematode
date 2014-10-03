package com.nematode.imaging;

public class MockEdgeDetectionRunner implements EdgeDetectionRunnerInterface {

	private boolean findAllObjectsInImageWasCalled = false;
	private ProcessedFrameImageInterface processedFrameImageToScan;

	@Override
	public void findAllObjectsInImage(
			final ProcessedFrameImageInterface processedFrameImage) {
		this.processedFrameImageToScan = processedFrameImage;
		this.findAllObjectsInImageWasCalled = true;
	}

	public boolean wasFindAllObjectsInImageCalled() {
		return this.findAllObjectsInImageWasCalled;
	}

	public ProcessedFrameImageInterface getProcessedFrameImageToScan() {
		return this.processedFrameImageToScan;
	}
}
