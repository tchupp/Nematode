package com.nematode.image;

import com.nematode.image.detection.ContourAreaCalculatorInterface;
import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.model.NematodeWormInterface;

public class MockContourAreaCalculator implements
ContourAreaCalculatorInterface {

	private boolean getAreaWasCalled = false;

	@Override
	public ContourAreaInterface getArea(final NematodeWormInterface worm) {
		this.getAreaWasCalled = true;
		return new MockContourArea();
	}

	public boolean wasGetAreaCalled() {
		return this.getAreaWasCalled;
	}

}
