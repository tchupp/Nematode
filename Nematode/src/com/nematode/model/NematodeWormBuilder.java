package com.nematode.model;

import com.nematode.imaging.ContourAreaCalculatorInterface;
import com.nematode.imaging.ContourAreaInterface;
import com.nematode.imaging.ContourLinesInterface;

public class NematodeWormBuilder implements NematodeWormBuilderInterface {

	private final ContourAreaCalculatorInterface contourAreaCalculator;

	public NematodeWormBuilder(
			final ContourAreaCalculatorInterface contourAreaCalculator) {
		this.contourAreaCalculator = contourAreaCalculator;
	}

	@Override
	public NematodeWormInterface buildWorm(
			final ContourLinesInterface contourLines) {

		final ContourAreaInterface contourArea = this.contourAreaCalculator
				.getArea(contourLines);

		return new NematodeWorm(contourLines, contourArea);
	}

	public ContourAreaCalculatorInterface getContourAreaCalculator() {
		return this.contourAreaCalculator;
	}
}