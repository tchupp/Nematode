package com.nematode.model;

import java.util.ArrayList;

import com.nematode.image.MockContourArea;
import com.nematode.image.MockContourLines;
import com.nematode.image.detection.ContourAreaCalculator;
import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.image.detection.ContourLines;
import com.nematode.image.detection.ContourLinesInterface;
import com.nematode.image.detection.ContourPoint;
import com.nematode.image.detection.ContourPointInterface;
import com.nematode.model.factory.NematodeWormBuilder;

public class MockNematodeWorm implements NematodeWormInterface {

	public static NematodeWormInterface makeMockWormForImageTesting() {
		final ArrayList<ContourPointInterface> arrayList = new ArrayList<ContourPointInterface>();
		final ContourLines contourLinesForWorm = new ContourLines(arrayList);
		arrayList.add(new ContourPoint(55, 40));
		arrayList.add(new ContourPoint(54, 40));
		arrayList.add(new ContourPoint(53, 40));
		arrayList.add(new ContourPoint(52, 40));
		arrayList.add(new ContourPoint(51, 40));
		arrayList.add(new ContourPoint(50, 40));
		arrayList.add(new ContourPoint(49, 40));
		arrayList.add(new ContourPoint(48, 40));
		arrayList.add(new ContourPoint(47, 40));
		arrayList.add(new ContourPoint(46, 40));
		arrayList.add(new ContourPoint(46, 39));
		arrayList.add(new ContourPoint(46, 38));
		arrayList.add(new ContourPoint(47, 37));
		arrayList.add(new ContourPoint(47, 36));
		arrayList.add(new ContourPoint(47, 35));
		arrayList.add(new ContourPoint(47, 34));
		arrayList.add(new ContourPoint(47, 33));
		arrayList.add(new ContourPoint(48, 32));
		arrayList.add(new ContourPoint(49, 32));
		arrayList.add(new ContourPoint(50, 32));
		arrayList.add(new ContourPoint(51, 32));
		arrayList.add(new ContourPoint(52, 33));
		arrayList.add(new ContourPoint(53, 34));
		arrayList.add(new ContourPoint(54, 34));
		arrayList.add(new ContourPoint(55, 34));
		arrayList.add(new ContourPoint(55, 35));
		arrayList.add(new ContourPoint(55, 36));
		arrayList.add(new ContourPoint(55, 37));
		arrayList.add(new ContourPoint(55, 38));
		arrayList.add(new ContourPoint(55, 39));

		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				new ContourAreaCalculator());
		final NematodeWormInterface worm = nematodeWormBuilder.buildWorm(contourLinesForWorm);

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
