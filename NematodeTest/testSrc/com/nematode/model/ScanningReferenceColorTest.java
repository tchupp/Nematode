package com.nematode.model;

import java.awt.Color;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ScanningReferenceColorTest extends AssertTestCase {

	@Test
	public void testGetsColorValue() throws Exception {
		final ScanningReferenceColor scanningReferenceColor = new ScanningReferenceColor(
				Color.BLUE);

		assertEquals(Color.BLUE, scanningReferenceColor.getReferenceColor());
	}
}
