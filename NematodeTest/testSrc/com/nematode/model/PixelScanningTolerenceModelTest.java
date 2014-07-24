package com.nematode.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.awt.Color;

import org.junit.Test;

public class PixelScanningTolerenceModelTest {

	@Test
	public void testGetsCorrectValuesPassedInConstruction() throws Exception {
		TolerancePercentage tolerancePercentage = new TolerancePercentage(10);
		PixelScanningTolerenceModel pixelScanningTolerenceModel = new PixelScanningTolerenceModel(
				Color.GRAY, tolerancePercentage);

		assertEquals(Color.GRAY,
				pixelScanningTolerenceModel.getReferenceColor());
		assertSame(tolerancePercentage,
				pixelScanningTolerenceModel.getTolerancePercentage());
	}

}
