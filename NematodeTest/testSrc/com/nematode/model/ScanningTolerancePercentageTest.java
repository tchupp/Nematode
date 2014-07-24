package com.nematode.model;

import junit.framework.TestCase;

import org.junit.Test;

public class ScanningTolerancePercentageTest extends TestCase {

	@Test
	public void testGetsCorrectValuesPassedInConstruction() throws Exception {
		ScanningTolerancePercentage tolerancePercentage1 = new ScanningTolerancePercentage(
				8);
		ScanningTolerancePercentage tolerancePercentage2 = new ScanningTolerancePercentage(
				11);

		assertEquals(.08, tolerancePercentage1.getTolerancePercentageValue());
		assertEquals(.11, tolerancePercentage2.getTolerancePercentageValue());
	}

}
