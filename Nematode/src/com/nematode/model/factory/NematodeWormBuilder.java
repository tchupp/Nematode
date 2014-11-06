package com.nematode.model.factory;

import com.nematode.image.detection.ContourAreaCalculatorInterface;
import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.image.detection.ContourLinesInterface;
import com.nematode.model.NematodeWorm;
import com.nematode.model.NematodeWormInterface;

public class NematodeWormBuilder implements NematodeWormBuilderInterface {

	private final ContourAreaCalculatorInterface contourAreaCalculator;

	public NematodeWormBuilder(final ContourAreaCalculatorInterface contourAreaCalculator) {
		this.contourAreaCalculator = contourAreaCalculator;
	}

	@Override
	public NematodeWormInterface buildWorm(final ContourLinesInterface contourLines) {
		final NematodeWorm nematodeWorm = new NematodeWorm(contourLines);

		final ContourAreaInterface contourArea = this.contourAreaCalculator.getArea(nematodeWorm);
		nematodeWorm.setContourArea(contourArea);

		return nematodeWorm;
	}

	public ContourAreaCalculatorInterface getContourAreaCalculator() {
		return this.contourAreaCalculator;
	}
}
