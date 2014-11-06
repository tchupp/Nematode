package com.nematode.image;

import com.nematode.image.detection.ContourAreaCalculatorInterface;
import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.model.NematodeWormInterface;

public class MockContourAreaCalculator implements ContourAreaCalculatorInterface {

	private boolean getAreaWasCalled = false;
	private NematodeWormInterface wormPassedInGetArea;
	private ContourAreaInterface areaToReturn;

	@Override
	public ContourAreaInterface getArea(final NematodeWormInterface worm) {
		this.wormPassedInGetArea = worm;
		this.getAreaWasCalled = true;
		return this.areaToReturn;
	}

	public void setAreaToReturn(final ContourAreaInterface areaToReturn) {
		this.areaToReturn = areaToReturn;
	}

	public boolean wasGetAreaCalled() {
		return this.getAreaWasCalled;
	}

	public NematodeWormInterface getWormPassedInGetArea() {
		return this.wormPassedInGetArea;
	}

}
