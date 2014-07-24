package com.nematode.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.awt.Color;

import org.junit.Test;

public class ScanningColorModelTest {

	@Test
	public void testGetsCorrectValuesPassedInConstruction() throws Exception {
		ScanningTolerancePercentage tolerancePercentage = new ScanningTolerancePercentage(
				10);
		ScanningReferenceColor referenceColor = new ScanningReferenceColor(
				Color.GRAY);

		ScanningColorModel pixelScanningTolerenceModel = new ScanningColorModel(
				referenceColor, tolerancePercentage);

		assertSame(referenceColor,
				pixelScanningTolerenceModel.getReferenceColor());
		assertSame(tolerancePercentage,
				pixelScanningTolerenceModel.getTolerancePercentage());
	}

	@Test
	public void testCorrectlyCalculatesHighAndLowRGBColors() throws Exception {
		Color simpleRGBColor = new Color(100, 100, 100);
		ScanningColorModel scanningColorModel = new ScanningColorModel(
				new ScanningReferenceColor(simpleRGBColor),
				new ScanningTolerancePercentage(10));

		assertEquals(new Color(110, 110, 110), scanningColorModel.getHighRGB());

		assertEquals(new Color(90, 90, 90), scanningColorModel.getLowRGB());
	}
}