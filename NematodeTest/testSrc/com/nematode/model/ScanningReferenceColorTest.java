package com.nematode.model;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

public class ScanningReferenceColorTest extends TestCase {

	@Test
	public void testGetsColorValue() throws Exception {
		ScanningReferenceColor scanningReferenceColor = new ScanningReferenceColor(
				Color.BLUE);

		assertEquals(Color.BLUE, scanningReferenceColor.getReferenceColor());
	}
}
