package com.nematode.image;

import java.util.ArrayList;
import java.util.List;

import com.nematode.image.detection.ContourLinesInterface;
import com.nematode.image.detection.ContourPointInterface;

public class MockContourLines implements ContourLinesInterface {

	private boolean empty = false;
	private List<ContourPointInterface> listOfContourPoints = new ArrayList<ContourPointInterface>();
	private List<ContourPointInterface> pointsAtX = new ArrayList<ContourPointInterface>();
	private List<ContourPointInterface> pointsAtY = new ArrayList<ContourPointInterface>();

	public void addContourPoint(final MockContourPoint contourPoint) {
		this.listOfContourPoints.add(contourPoint);
	}

	public void setListOfContourPoints(
			final ArrayList<ContourPointInterface> listOfPoints) {
		this.listOfContourPoints = listOfPoints;
	}

	@Override
	public List<ContourPointInterface> getListOfContourPoints() {
		return this.listOfContourPoints;
	}

	public void setPointsAtX(final ArrayList<ContourPointInterface> pointsAtX) {
		this.pointsAtX = pointsAtX;
	}

	@Override
	public List<ContourPointInterface> getPointsAtX(final int x) {
		return this.pointsAtX;
	}

	public void setPointsAtY(final ArrayList<ContourPointInterface> pointsAtY) {
		this.pointsAtY = pointsAtY;
	}

	@Override
	public List<ContourPointInterface> getPointsAtY(final int y) {
		return this.pointsAtY;
	}

	@Override
	public boolean isEmpty() {
		return this.empty;
	}

	public void setEmpty(final boolean empty) {
		this.empty = empty;
	}

}
