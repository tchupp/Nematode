package com.nematode.image.detection;

import java.util.ArrayList;
import java.util.List;

public class ContourLines implements ContourLinesInterface {

	private final List<ContourPointInterface> listOfContourPoints;

	public ContourLines(final List<ContourPointInterface> listOfContourPoints) {
		this.listOfContourPoints = listOfContourPoints;
	}

	@Override
	public List<ContourPointInterface> getListOfContourPoints() {
		return this.listOfContourPoints;
	}

	@Override
	public List<ContourPointInterface> getPointsAtX(final int x) {
		final List<ContourPointInterface> pointsAtX = new ArrayList<ContourPointInterface>();
		for (final ContourPointInterface contourPoint : this.listOfContourPoints) {
			if (contourPoint.getX() == x) {
				pointsAtX.add(contourPoint);
			}
		}
		return pointsAtX;
	}

	@Override
	public List<ContourPointInterface> getPointsAtY(final int y) {
		final List<ContourPointInterface> pointsAtY = new ArrayList<ContourPointInterface>();
		for (final ContourPointInterface contourPoint : this.listOfContourPoints) {
			if (contourPoint.getY() == y) {
				pointsAtY.add(contourPoint);
			}
		}
		return pointsAtY;
	}

	@Override
	public boolean isEmpty() {
		return this.listOfContourPoints.isEmpty();
	}
}
