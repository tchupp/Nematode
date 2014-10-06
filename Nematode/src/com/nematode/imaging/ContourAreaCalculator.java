package com.nematode.imaging;

import java.util.ArrayList;

public class ContourAreaCalculator implements ContourAreaCalculatorInterface {

	@Override
	public ContourAreaInterface getArea(final ContourLinesInterface lines) {
		return new ContourArea(new ArrayList<InnerPointInterface>());
	}
}
