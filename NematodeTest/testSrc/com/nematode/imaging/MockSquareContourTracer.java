package com.nematode.imaging;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MockSquareContourTracer implements SquareContourTracerInterface {

	ContourLines points = new ContourLines(new ArrayList<ContourPoint>());

	@Override
	public ContourLines getContourLines(final BufferedImage image) {
		return this.points;
	}

	public void setContourLinesToReturn(final ContourLines points) {
		this.points = points;
	}

}
