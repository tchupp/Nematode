package com.nematode.image.detection;

import com.nematode.model.NematodeWormInterface;

public class ContourAreaCalculationThread extends Thread {

	private final NematodeWormInterface worm;
	private final ContourAreaCalculatorInterface areaCalculator;

	public ContourAreaCalculationThread(final NematodeWormInterface worm,
			final ContourAreaCalculatorInterface areaCalculator) {
		this.worm = worm;
		this.areaCalculator = areaCalculator;
	}

	@Override
	public void run() {
		final ContourAreaInterface area = this.areaCalculator.getArea(this.worm);
		this.worm.setContourArea(area);
	}

	public NematodeWormInterface getWorm() {
		return this.worm;
	}

	public ContourAreaCalculatorInterface getAreaCalculator() {
		return this.areaCalculator;
	}
}
