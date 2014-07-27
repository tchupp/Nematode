package com.nematode.model;

import java.awt.Color;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ScanningColorModelTest extends AssertTestCase {

	@Test
	public void testGetsCorrectValuesPassedInConstruction() throws Exception {
		final ScanningTolerancePercentage tolerancePercentage = new ScanningTolerancePercentage(
				10);
		final ScanningReferenceColor referenceColor = new ScanningReferenceColor(
				Color.GRAY);

		final ScanningColorModel pixelScanningTolerenceModel = new ScanningColorModel(
				referenceColor, tolerancePercentage);

		assertSame(referenceColor,
				pixelScanningTolerenceModel.getReferenceColor());
		assertSame(tolerancePercentage,
				pixelScanningTolerenceModel.getTolerancePercentage());
	}

	@Test
	public void testCorrectlyCalculatesHighAndLowRGBColors() throws Exception {
		final Color simpleRGBColor = new Color(100, 100, 100);
		final ScanningColorModel scanningColorModel = new ScanningColorModel(
				new ScanningReferenceColor(simpleRGBColor),
				new ScanningTolerancePercentage(10));

		assertEquals(new Color(110, 110, 110), scanningColorModel.getHighRGB());

		assertEquals(new Color(90, 90, 90), scanningColorModel.getLowRGB());
	}
}