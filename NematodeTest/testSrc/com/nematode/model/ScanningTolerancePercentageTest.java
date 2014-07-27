package com.nematode.model;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ScanningTolerancePercentageTest extends AssertTestCase {

	@Test
	public void testGetsCorrectValuesPassedInConstruction() throws Exception {
		final ScanningTolerancePercentage tolerancePercentage1 = new ScanningTolerancePercentage(
				8);
		final ScanningTolerancePercentage tolerancePercentage2 = new ScanningTolerancePercentage(
				11);

		assertEquals(.08, tolerancePercentage1.getTolerancePercentageValue());
		assertEquals(.11, tolerancePercentage2.getTolerancePercentageValue());
	}

}
