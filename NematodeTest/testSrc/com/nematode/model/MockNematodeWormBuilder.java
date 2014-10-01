package com.nematode.model;

import com.nematode.imaging.ContourPointsInterface;

public class MockNematodeWormBuilder implements NematodeWormBuilderInterface {

	@Override
	public NematodeWormInterface buildWorm(
			final ContourPointsInterface contourPoints) {
		return new MockNematodeWorm();
	}

}
