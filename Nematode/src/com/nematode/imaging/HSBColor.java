package com.nematode.imaging;

import java.awt.Color;

public class HSBColor extends Color {

	private static final long serialVersionUID = 1L;
	private float hue;
	private float saturation;
	private float brightness;

	public HSBColor(final Color color) {
		super(color.getRGB());

		final int r = color.getRed();
		final int g = color.getGreen();
		final int b = color.getBlue();
		calculateHSB(r, g, b);
	}

	public HSBColor(final int red, final int green, final int blue) {
		super(red, green, blue);
		calculateHSB(red, green, blue);
	}

	private void calculateHSB(final int r, final int g, final int b) {
		final float[] hsbValues = new float[3];
		Color.RGBtoHSB(r, g, b, hsbValues);
		this.hue = hsbValues[0];
		this.saturation = hsbValues[1];
		this.brightness = hsbValues[2];
	}

	public float getHue() {
		return this.hue;
	}

	public float getSaturation() {
		return this.saturation;
	}

	public float getBrightness() {
		return this.brightness;
	}
}
