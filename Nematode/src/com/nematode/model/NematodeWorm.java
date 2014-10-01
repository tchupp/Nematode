package com.nematode.model;

import com.nematode.imaging.ContourLinesInterface;

public class NematodeWorm implements NematodeWormInterface {

	private final ContourLinesInterface contourLines;

	public NematodeWorm(final ContourLinesInterface contourLines) {
		this.contourLines = contourLines;
	}

	@Override
	public ContourLinesInterface getContourLines() {
		return this.contourLines;
	}

}
