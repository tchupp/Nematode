package com.nematode.image;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.image.detection.EdgeDetectionRunnerInterface;
import com.nematode.model.NematodeWormInterface;

public class MockEdgeDetectionRunner implements EdgeDetectionRunnerInterface {

	private boolean findAllObjectsInImageWasCalled = false;
	private ProcessedFrameImageInterface processedFrameImageToScan;
	private ArrayList<NematodeWormInterface> objectsInImageList = new ArrayList<NematodeWormInterface>();

	@Override
	public List<NematodeWormInterface> findAllObjectsInImage(
			final ProcessedFrameImageInterface processedFrameImage) {
		this.processedFrameImageToScan = processedFrameImage;
		this.findAllObjectsInImageWasCalled = true;

		return this.objectsInImageList;
	}

	public void setObjectsInImageList(
			final ArrayList<NematodeWormInterface> objectsInImageList) {
		this.objectsInImageList = objectsInImageList;
	}

	public boolean wasFindAllObjectsInImageCalled() {
		return this.findAllObjectsInImageWasCalled;
	}

	public ProcessedFrameImageInterface getProcessedFrameImageToScan() {
		return this.processedFrameImageToScan;
	}
}
