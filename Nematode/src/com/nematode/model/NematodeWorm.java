package com.nematode.model;

import com.nematode.imaging.ContourPointsInterface;

public class NematodeWorm implements NematodeWormInterface {

	private final ContourPointsInterface contourPoints;

	public NematodeWorm(final ContourPointsInterface contourPoints) {
		this.contourPoints = contourPoints;
	}

	@Override
	public ContourPointsInterface getContourPoints() {
		return this.contourPoints;
	}

}
