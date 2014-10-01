package com.nematode.model;

import com.nematode.imaging.ContourPointsInterface;
import com.nematode.imaging.MockContourPoints;

public class MockNematodeWorm implements NematodeWormInterface {

	@Override
	public ContourPointsInterface getContourPoints() {
		return new MockContourPoints();
	}

}
