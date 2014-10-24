package com.nematode.model;

import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.image.detection.ContourLinesInterface;


public class NematodeWorm implements NematodeWormInterface {

	private final ContourLinesInterface contourLines;
	private final ContourAreaInterface contourArea;

	public NematodeWorm(final ContourLinesInterface contourLines,
			final ContourAreaInterface contourArea) {
		this.contourLines = contourLines;
		this.contourArea = contourArea;
	}

	@Override
	public ContourLinesInterface getContourLines() {
		return this.contourLines;
	}

	@Override
	public ContourAreaInterface getContourArea() {
		return this.contourArea;
	}

}
