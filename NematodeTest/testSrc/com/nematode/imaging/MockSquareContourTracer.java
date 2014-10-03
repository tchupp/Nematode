package com.nematode.imaging;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MockSquareContourTracer implements SquareContourTracerInterface {

	ContourLines points = new ContourLines(
			new ArrayList<ContourPointInterface>());
	private boolean getFirstContourLinesWasCalled = false;

	@Override
	public ContourLines getFirstContourLines(final BufferedImage image) {
		this.getFirstContourLinesWasCalled = true;
		return this.points;
	}

	public boolean wasGetFirstContourLinesCalled() {
		return this.getFirstContourLinesWasCalled;
	}

	public void setContourLinesToReturn(final ContourLines points) {
		this.points = points;
	}

}
