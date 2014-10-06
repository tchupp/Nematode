package com.nematode.model;

import com.nematode.imaging.ContourAreaInterface;
import com.nematode.imaging.ContourLinesInterface;
import com.nematode.imaging.MockContourArea;
import com.nematode.imaging.MockContourLines;
import com.nematode.imaging.MockContourPoint;

public class MockNematodeWorm implements NematodeWormInterface {

	public static MockNematodeWorm makeMockWormForImageTesting() {
		final MockContourLines mockContourLines = new MockContourLines();
		mockContourLines.addContourPoint(new MockContourPoint(55, 40));
		mockContourLines.addContourPoint(new MockContourPoint(54, 40));
		mockContourLines.addContourPoint(new MockContourPoint(53, 40));
		mockContourLines.addContourPoint(new MockContourPoint(52, 40));
		mockContourLines.addContourPoint(new MockContourPoint(51, 40));
		mockContourLines.addContourPoint(new MockContourPoint(50, 40));
		mockContourLines.addContourPoint(new MockContourPoint(49, 40));
		mockContourLines.addContourPoint(new MockContourPoint(48, 40));
		mockContourLines.addContourPoint(new MockContourPoint(47, 40));
		mockContourLines.addContourPoint(new MockContourPoint(46, 40));
		mockContourLines.addContourPoint(new MockContourPoint(46, 39));
		mockContourLines.addContourPoint(new MockContourPoint(46, 38));
		mockContourLines.addContourPoint(new MockContourPoint(47, 37));
		mockContourLines.addContourPoint(new MockContourPoint(47, 36));
		mockContourLines.addContourPoint(new MockContourPoint(47, 35));
		mockContourLines.addContourPoint(new MockContourPoint(47, 34));
		mockContourLines.addContourPoint(new MockContourPoint(47, 33));
		mockContourLines.addContourPoint(new MockContourPoint(48, 32));
		mockContourLines.addContourPoint(new MockContourPoint(49, 32));
		mockContourLines.addContourPoint(new MockContourPoint(50, 32));
		mockContourLines.addContourPoint(new MockContourPoint(51, 32));
		mockContourLines.addContourPoint(new MockContourPoint(52, 33));
		mockContourLines.addContourPoint(new MockContourPoint(53, 34));
		mockContourLines.addContourPoint(new MockContourPoint(54, 34));
		mockContourLines.addContourPoint(new MockContourPoint(55, 34));
		mockContourLines.addContourPoint(new MockContourPoint(55, 35));
		mockContourLines.addContourPoint(new MockContourPoint(55, 36));
		mockContourLines.addContourPoint(new MockContourPoint(55, 37));
		mockContourLines.addContourPoint(new MockContourPoint(55, 38));
		mockContourLines.addContourPoint(new MockContourPoint(55, 39));

		final MockNematodeWorm worm = new MockNematodeWorm();

		worm.setContourLines(mockContourLines);

		return worm;
	}

	private ContourLinesInterface contourLines = new MockContourLines();
	private ContourAreaInterface contourArea = new MockContourArea();

	@Override
	public ContourLinesInterface getContourLines() {
		return this.contourLines;
	}

	public void setContourLines(final ContourLinesInterface contourLines) {
		this.contourLines = contourLines;
	}

	@Override
	public ContourAreaInterface getContourArea() {
		return this.contourArea;
	}

	public void setContourArea(final ContourAreaInterface contourArea) {
		this.contourArea = contourArea;
	}

}
