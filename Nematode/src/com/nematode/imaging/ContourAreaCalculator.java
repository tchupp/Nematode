package com.nematode.imaging;

import java.util.ArrayList;
import java.util.List;

public class ContourAreaCalculator implements ContourAreaCalculatorInterface {

	private int northBound;
	private int eastBound;
	private int southBound;
	private int westBound;

	@Override
	public ContourAreaInterface getArea(final ContourLinesInterface lines) {
		this.northBound = findNorthBound(lines) - 1;
		this.eastBound = findEastBound(lines) + 1;
		this.southBound = findSouthBound(lines) + 1;
		this.westBound = findWestBound(lines) - 1;

		final List<ContourPointInterface> outerPoints = new ArrayList<ContourPointInterface>(
				lines.getListOfContourPoints());

		outerFloodFill(this.northBound, this.westBound, outerPoints);
		return new ContourArea(reverseArea(outerPoints));
	}

	private void outerFloodFill(final int x, final int y,
			final List<ContourPointInterface> bounds) {
		if (bounds.contains(new ContourPoint(x, y))) {
			return;
		} else {
			bounds.add(new ContourPoint(x, y));
		}
		if (y > this.northBound) {
			outerFloodFill(x, y - 1, bounds);
		}
		if (y < this.southBound) {
			outerFloodFill(x, y + 1, bounds);
		}
		if (x > this.westBound) {
			outerFloodFill(x - 1, y, bounds);
		}
		if (x < this.eastBound) {
			outerFloodFill(x + 1, y, bounds);
		}
	}

	private List<InnerPointInterface> reverseArea(
			final List<ContourPointInterface> bounds) {
		final ArrayList<InnerPointInterface> innerPoints = new ArrayList<InnerPointInterface>();
		for (int x = this.westBound; x <= this.eastBound; x++) {
			for (int y = this.northBound; y <= this.southBound; y++) {
				if (!bounds.contains(new ContourPoint(x, y))) {
					innerPoints.add(new InnerPoint(x, y));
				}
			}
		}

		return innerPoints;
	}

	private int findNorthBound(final ContourLinesInterface lines) {
		List<ContourPointInterface> pointsAtY = new ArrayList<ContourPointInterface>();
		int yPosition = 0;

		while (pointsAtY.isEmpty()) {
			pointsAtY = lines.getPointsAtY(yPosition++);
		}

		return --yPosition;
	}

	private int findEastBound(final ContourLinesInterface lines) {
		List<ContourPointInterface> pointsAtX = new ArrayList<ContourPointInterface>();
		int xPosition = -1;

		while (pointsAtX.isEmpty()) {
			pointsAtX = lines.getPointsAtX(++xPosition);
		}

		--xPosition;
		while (!pointsAtX.isEmpty()) {
			pointsAtX = lines.getPointsAtX(++xPosition);
		}

		return --xPosition;
	}

	private int findSouthBound(final ContourLinesInterface lines) {
		List<ContourPointInterface> pointsAtY = new ArrayList<ContourPointInterface>();
		int yPosition = -1;

		while (pointsAtY.isEmpty()) {
			pointsAtY = lines.getPointsAtY(++yPosition);
		}

		--yPosition;
		while (!pointsAtY.isEmpty()) {
			pointsAtY = lines.getPointsAtY(++yPosition);
		}

		return --yPosition;
	}

	private int findWestBound(final ContourLinesInterface lines) {
		List<ContourPointInterface> pointsAtX = new ArrayList<ContourPointInterface>();
		int xPosition = 0;

		while (pointsAtX.isEmpty()) {
			pointsAtX = lines.getPointsAtX(xPosition++);
		}

		return --xPosition;
	}
}
