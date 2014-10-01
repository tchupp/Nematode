package com.nematode.model;

import com.nematode.imaging.ContourLinesInterface;

public class MockNematodeWormBuilder implements NematodeWormBuilderInterface {

	@Override
	public NematodeWormInterface buildWorm(
			final ContourLinesInterface contourLines) {
		return new MockNematodeWorm();
	}

}
