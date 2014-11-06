package com.nematode.model;

import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.image.detection.ContourLinesInterface;
import com.nematode.image.detection.NullContourArea;

public class NematodeWorm implements NematodeWormInterface {

	private final ContourLinesInterface contourLines;
	private ContourAreaInterface contourArea;

	public NematodeWorm(final ContourLinesInterface contourLines) {
		this.contourLines = contourLines;
		this.contourArea = new NullContourArea();
	}

	@Override
	public ContourLinesInterface getContourLines() {
		return this.contourLines;
	}

	@Override
	public void setContourArea(final ContourAreaInterface contourArea) {
		this.contourArea = contourArea;
	}

	@Override
	public ContourAreaInterface getContourArea() {
		return this.contourArea;
	}

}
