package com.nematode.image;

import com.nematode.image.detection.ContourAreaCalculatorInterface;
import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.image.detection.ContourLinesInterface;

public class MockContourAreaCalculator implements
ContourAreaCalculatorInterface {

	private boolean getAreaWasCalled = false;

	@Override
	public ContourAreaInterface getArea(final ContourLinesInterface lines) {
		this.getAreaWasCalled = true;
		return new MockContourArea();
	}

	public boolean wasGetAreaCalled() {
		return this.getAreaWasCalled;
	}

}
