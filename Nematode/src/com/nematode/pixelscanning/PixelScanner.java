package com.nematode.pixelscanning;

import java.awt.image.BufferedImage;

import com.nematode.model.ScanningColorModel;
import com.nematode.model.ScanningReferenceColor;

public class PixelScanner {

	private BufferedImage bufferedInputImage;
	private ScanningColorModel scanningColorModel;

	public PixelScanner(BufferedImage bufferedInputImage,
			ScanningColorModel scanningColorModel) {
		this.bufferedInputImage = bufferedInputImage;
		this.scanningColorModel = scanningColorModel;

		determineRGBRanges();
	}

	private void determineRGBRanges() {
		ScanningReferenceColor referenceColor = scanningColorModel
				.getReferenceColor();
		double tolerancePercentageValue = scanningColorModel
				.getTolerancePercentage().getTolerancePercentageValue();

		int red = referenceColor.getReferenceColor().getRed();
		int green = referenceColor.getReferenceColor().getGreen();
		int blue = referenceColor.getReferenceColor().getBlue();

		long redHigh = Math.round(red * (1 + tolerancePercentageValue));
		long greenHigh = Math.round(green * (1 + tolerancePercentageValue));
		long blueHigh = Math.round(blue * (1 + tolerancePercentageValue));

		long redLow = Math.round(red * (1 - tolerancePercentageValue));
		long greenLow = Math.round(green * (1 - tolerancePercentageValue));
		long blueLow = Math.round(blue * (1 - tolerancePercentageValue));
	}

	public void scan() {

	}

	public int getPercentOfImageWithinTolerance() {
		return 0;
	}
}
