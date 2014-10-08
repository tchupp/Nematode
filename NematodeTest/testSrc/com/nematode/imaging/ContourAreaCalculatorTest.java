package com.nematode.imaging;

import java.util.ArrayList;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ContourAreaCalculatorTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ContourAreaCalculatorInterface.class,
				ContourAreaCalculator.class);
	}

	@Test
	public void testGetAreaCalculatesInnerPointsOfContourLines()
			throws Exception {
		final ArrayList<ContourPointInterface> listOfContourPoints = new ArrayList<ContourPointInterface>();
		final ContourLines contourLines = new ContourLines(listOfContourPoints);
		listOfContourPoints.add(new ContourPoint(1, 1));
		listOfContourPoints.add(new ContourPoint(2, 1));
		listOfContourPoints.add(new ContourPoint(3, 1));
		listOfContourPoints.add(new ContourPoint(3, 2));
		listOfContourPoints.add(new ContourPoint(3, 3));
		listOfContourPoints.add(new ContourPoint(2, 3));
		listOfContourPoints.add(new ContourPoint(1, 3));
		listOfContourPoints.add(new ContourPoint(1, 2));

		final ContourAreaInterface area = new ContourAreaCalculator()
		.getArea(contourLines);

		assertEquals(1, area.getSize());
	}
}
