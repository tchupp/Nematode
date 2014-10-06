package com.nematode.imaging;

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
		fail("unimplemented");
	}

}
