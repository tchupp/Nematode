package com.nematode.model;

import com.nematode.imaging.ContourLinesInterface;
import com.nematode.imaging.MockContourLines;

public class MockNematodeWorm implements NematodeWormInterface {

	@Override
	public ContourLinesInterface getContourLines() {
		return new MockContourLines();
	}

}
