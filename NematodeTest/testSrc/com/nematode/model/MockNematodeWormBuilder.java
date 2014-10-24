package com.nematode.model;

import com.nematode.image.detection.ContourLinesInterface;
import com.nematode.model.factory.NematodeWormBuilderInterface;

public class MockNematodeWormBuilder implements NematodeWormBuilderInterface {

	private ContourLinesInterface contourLinesBuiltWith;
	private boolean buildWormWasCalled;

	@Override
	public NematodeWormInterface buildWorm(
			final ContourLinesInterface contourLines) {
		this.contourLinesBuiltWith = contourLines;
		this.buildWormWasCalled = true;
		return new MockNematodeWorm();
	}

	public boolean wasBuildWormCalled() {
		return this.buildWormWasCalled;
	}

	public ContourLinesInterface getContourLinesBuiltWith() {
		return this.contourLinesBuiltWith;
	}

}
