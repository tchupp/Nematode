package com.nematode.model;

import java.awt.Color;

public class ScanningColorModel {

	private ScanningTolerancePercentage tolerancePercentage;
	private ScanningReferenceColor referenceColor;

	public ScanningColorModel(ScanningReferenceColor referenceColor,
			ScanningTolerancePercentage tolerancePercentage) {
		this.referenceColor = referenceColor;
		this.tolerancePercentage = tolerancePercentage;
	}

	public ScanningReferenceColor getReferenceColor() {
		return this.referenceColor;
	}

	public ScanningTolerancePercentage getTolerancePercentage() {
		return this.tolerancePercentage;
	}

	public Color getHighRGB() {
		double tolerancePercentageValue = this.tolerancePercentage
				.getTolerancePercentageValue();

		int red = this.referenceColor.getReferenceColor().getRed();
		int green = this.referenceColor.getReferenceColor().getGreen();
		int blue = this.referenceColor.getReferenceColor().getBlue();

		long redHigh = (int) Math.round(red * (1 + tolerancePercentageValue));
		long greenHigh = (int) Math.round(green
				* (1 + tolerancePercentageValue));
		long blueHigh = (int) Math.round(blue * (1 + tolerancePercentageValue));

		return new Color(redHigh, greenHigh, blueHigh);
	}

	public Color getLowRGB() {
		double tolerancePercentageValue = this.tolerancePercentage
				.getTolerancePercentageValue();

		int red = this.referenceColor.getReferenceColor().getRed();
		int green = this.referenceColor.getReferenceColor().getGreen();
		int blue = this.referenceColor.getReferenceColor().getBlue();

		long redLow = Math.round(red * (1 - tolerancePercentageValue));
		long greenLow = Math.round(green * (1 - tolerancePercentageValue));
		long blueLow = Math.round(blue * (1 - tolerancePercentageValue));

		return new Color(redLow, greenLow, blueLow);

	}
}
