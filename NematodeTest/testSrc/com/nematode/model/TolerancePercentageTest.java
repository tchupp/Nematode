package com.nematode.model;

import junit.framework.TestCase;

import org.junit.Test;

public class TolerancePercentageTest extends TestCase {

	@Test
	public void testGetsCorrectValuesPassedInConstruction() throws Exception {
		TolerancePercentage tolerancePercentage1 = new TolerancePercentage(8);
		TolerancePercentage tolerancePercentage2 = new TolerancePercentage(11);

		assertEquals(8.0, tolerancePercentage1.getTolerancePercentageValue());
		assertEquals(11.0, tolerancePercentage2.getTolerancePercentageValue());
	}

}
