package com.nematode.model;

import java.awt.Color;

public class PixelScanningTolerenceModel {

	private Color referenceColor;
	private TolerancePercentage tolerancePercentage;

	public PixelScanningTolerenceModel(Color referenceColor,
			TolerancePercentage tolerancePercentage) {
		this.referenceColor = referenceColor;
		this.tolerancePercentage = tolerancePercentage;
	}

	public Color getReferenceColor() {
		return referenceColor;
	}

	public TolerancePercentage getTolerancePercentage() {
		return tolerancePercentage;
	}
}
