package com.nematode.image.detection;

import java.util.ArrayList;

import org.junit.Test;

import com.nematode.model.MockNematodeWorm;
import com.nematode.unittesting.AssertTestCase;

public class ContourAreaCalculatorTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ContourAreaCalculatorInterface.class, ContourAreaCalculator.class);
	}

	@Test
	public void testGetAreaCalculatesInnerPointsOfContourLines() throws Exception {
		final ArrayList<ContourPointInterface> listOfContourPoints = new ArrayList<ContourPointInterface>();
		final ContourLines contourLines = new ContourLines(listOfContourPoints);
		listOfContourPoints.add(new ContourPoint(1, 1));
		listOfContourPoints.add(new ContourPoint(2, 1));
		listOfContourPoints.add(new ContourPoint(3, 1));
		listOfContourPoints.add(new ContourPoint(4, 1));
		listOfContourPoints.add(new ContourPoint(4, 2));
		listOfContourPoints.add(new ContourPoint(4, 3));
		listOfContourPoints.add(new ContourPoint(3, 3));
		listOfContourPoints.add(new ContourPoint(2, 3));
		listOfContourPoints.add(new ContourPoint(1, 3));
		listOfContourPoints.add(new ContourPoint(1, 2));
		final MockNematodeWorm mockNematodeWorm = new MockNematodeWorm();
		mockNematodeWorm.setContourLines(contourLines);

		final ContourAreaInterface area = new ContourAreaCalculator().getArea(mockNematodeWorm);

		assertEquals(2, area.getSize());
	}
}
