package com.nematode.imaging;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MockSquareContourTracer implements SquareContourTracerInterface {

	ContourPoints points = new ContourPoints(new ArrayList<ContourPoint>());

	@Override
	public ContourPoints getContourPoints(final BufferedImage image) {
		return this.points;
	}

	public void setContourPointsToReturn(final ContourPoints points) {
		this.points = points;
	}

}
