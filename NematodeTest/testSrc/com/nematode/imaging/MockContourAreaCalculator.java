package com.nematode.imaging;

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
