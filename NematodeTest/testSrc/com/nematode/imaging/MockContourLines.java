package com.nematode.imaging;

import java.util.ArrayList;
import java.util.List;

public class MockContourLines implements ContourLinesInterface {

	private List<MockContourPoint> listOfContourPoints = new ArrayList<MockContourPoint>();
	private boolean empty = true;
	private ArrayList<MockContourPoint> pointsAtY;
	private ArrayList<MockContourPoint> pointsAtX;

	public void addContourPoint(final MockContourPoint contourPoint) {
		this.listOfContourPoints.add(contourPoint);
	}

	public void setListOfContourPoints(
			final List<MockContourPoint> listOfContourPoints) {
		this.listOfContourPoints = listOfContourPoints;
	}

	@Override
	public List<MockContourPoint> getListOfContourPoints() {
		return this.listOfContourPoints;
	}

	public void setPointsAtX(final ArrayList<MockContourPoint> pointsAtX) {
		this.pointsAtX = pointsAtX;
	}

	@Override
	public List<? extends ContourPointInterface> getPointsAtX(final int x) {
		this.pointsAtX = new ArrayList<MockContourPoint>();
		return this.pointsAtX;
	}

	public void setPointsAtY(final ArrayList<MockContourPoint> pointsAtY) {
		this.pointsAtY = pointsAtY;
	}

	@Override
	public List<? extends ContourPointInterface> getPointsAtY(final int y) {
		this.pointsAtY = new ArrayList<MockContourPoint>();
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
