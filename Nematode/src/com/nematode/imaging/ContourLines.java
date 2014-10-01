package com.nematode.imaging;

import java.util.ArrayList;
import java.util.List;

public class ContourLines implements ContourLinesInterface {

	private final List<ContourPoint> listOfContourPoints;

	public ContourLines(final List<ContourPoint> listOfContourPoints) {
		this.listOfContourPoints = listOfContourPoints;
	}

	@Override
	public List<ContourPoint> getListOfContourPoints() {
		return this.listOfContourPoints;
	}

	@Override
	public List<ContourPoint> getPointsAtX(final int x) {
		final List<ContourPoint> pointsAtX = new ArrayList<ContourPoint>();
		for (final ContourPoint contourPoint : this.listOfContourPoints) {
			if (contourPoint.getX() == x) {
				pointsAtX.add(contourPoint);
			}
		}
		return pointsAtX;
	}

	@Override
	public List<ContourPoint> getPointsAtY(final int y) {
		final List<ContourPoint> pointsAtY = new ArrayList<ContourPoint>();
		for (final ContourPoint contourPoint : this.listOfContourPoints) {
			if (contourPoint.getY() == y) {
				pointsAtY.add(contourPoint);
			}
		}
		return pointsAtY;
	}
}
