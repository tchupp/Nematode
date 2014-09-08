package com.nematode.imaging;

import java.awt.Color;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class HSBColorTest extends AssertTestCase {

	@Test
	public void testExtendsColor() throws Exception {
		assertExtends(Color.class, HSBColor.class);
	}

	@Test
	public void testCorrectlyCalculatesHueSaturationAndValueFromJavaColors()
			throws Exception {
		final HSBColor hsbRed = new HSBColor(Color.RED);
		final HSBColor hsbBlue = new HSBColor(Color.BLUE);
		final HSBColor hsbGreen = new HSBColor(Color.GREEN);

		assertEquals(0.0, hsbRed.getHue(), 0.001);
		assertEquals(1.0, hsbRed.getSaturation(), 0.001);
		assertEquals(1.0, hsbRed.getBrightness(), 0.001);

		assertEquals(0.666, hsbBlue.getHue(), 0.001);
		assertEquals(1.0, hsbBlue.getSaturation(), 0.001);
		assertEquals(1.0, hsbBlue.getBrightness(), 0.001);

		assertEquals(0.333, hsbGreen.getHue(), 0.001);
		assertEquals(1.0, hsbGreen.getSaturation(), 0.001);
		assertEquals(1.0, hsbGreen.getBrightness(), 0.001);
	}

	@Test
	public void testCorrectlyCalculatesHueSaturationAndValueFromCustomColors()
			throws Exception {
		final HSBColor hsbCustomMagenta = new HSBColor(127, 63, 255);
		assertEquals(0.722, hsbCustomMagenta.getHue(), 0.001);
		assertEquals(0.753, hsbCustomMagenta.getSaturation(), 0.001);
		assertEquals(1.0, hsbCustomMagenta.getBrightness(), 0.001);

		final HSBColor hsbCustomPeach = new HSBColor(255, 127, 52);
		assertEquals(.062, hsbCustomPeach.getHue(), 0.001);
		assertEquals(0.796, hsbCustomPeach.getSaturation(), 0.001);
		assertEquals(1.0, hsbCustomPeach.getBrightness(), 0.001);
	}
}
