package com.nematode.image.detection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.nematode.model.NematodeWormInterface;

public class ContourAreaCalculator implements ContourAreaCalculatorInterface {

	private int northBound;
	private int eastBound;
	private int southBound;
	private int westBound;

	@Override
	public ContourAreaInterface getArea(final NematodeWormInterface worm) {
		final ContourLinesInterface contourLines = worm.getContourLines();
		this.northBound = findNorthBound(contourLines) - 1;
		this.eastBound = findEastBound(contourLines) + 1;
		this.southBound = findSouthBound(contourLines) + 1;
		this.westBound = findWestBound(contourLines) - 1;

		final List<ContourPointInterface> innerBounds = new ArrayList<ContourPointInterface>(
				contourLines.getListOfContourPoints());

		final List<ContourPointInterface> outerPoints = outerFloodFill(innerBounds);
		outerPoints.addAll(innerBounds);
		return new ContourArea(reverseArea(outerPoints));
	}

	private List<ContourPointInterface> outerFloodFill(final List<ContourPointInterface> innerBounds) {
		final Deque<ContourPointInterface> queue = new ArrayDeque<ContourPointInterface>();
		final List<ContourPointInterface> outerPoints = new ArrayList<ContourPointInterface>();
		final int x = this.westBound, y = this.northBound;
		queue.addLast(new ContourPoint(x, y));
		while (!queue.isEmpty()) {
			final ContourPointInterface point = queue.removeFirst();
			final int pointX = point.getX(), pointY = point.getY();

			if (checkValidity(pointX + 1, pointY, innerBounds, outerPoints)) {
				if (addOuterPoint(pointX + 1, pointY, outerPoints)) {
					queue.addLast(new ContourPoint(pointX + 1, pointY));
				}
			}
			if (checkValidity(pointX - 1, pointY, innerBounds, outerPoints)) {
				if (addOuterPoint(pointX - 1, pointY, outerPoints)) {
					queue.addLast(new ContourPoint(pointX - 1, pointY));
				}
			}
			if (checkValidity(pointX, pointY + 1, innerBounds, outerPoints)) {
				if (addOuterPoint(pointX, pointY + 1, outerPoints)) {
					queue.addLast(new ContourPoint(pointX, pointY + 1));
				}
			}
			if (checkValidity(pointX, pointY - 1, innerBounds, outerPoints)) {
				if (addOuterPoint(pointX, pointY - 1, outerPoints)) {
					queue.addLast(new ContourPoint(pointX, pointY - 1));
				}
			}
		}
		return outerPoints;
	}

	private boolean checkValidity(final int x, final int y,
			final List<ContourPointInterface> innerBounds,
			final List<ContourPointInterface> outerPoints) {
		if (x < this.westBound) {
			return false;
		}
		if (x > this.eastBound) {
			return false;
		}
		if (y < this.northBound) {
			return false;
		}
		if (y > this.southBound) {
			return false;
		}
		if (innerBounds.contains(new ContourPoint(x, y))) {
			return false;
		}
		if (outerPoints.contains(new ContourPoint(x, y))) {
			return false;
		}
		return true;
	}

	private boolean addOuterPoint(final int x, final int y,
			final List<ContourPointInterface> outerPoints) {
		final ContourPoint potentialPoint = new ContourPoint(x, y);
		if (!outerPoints.contains(potentialPoint)) {
			outerPoints.add(potentialPoint);
			return true;
		}
		return false;
	}

	private List<InnerPointInterface> reverseArea(final List<ContourPointInterface> bounds) {
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
