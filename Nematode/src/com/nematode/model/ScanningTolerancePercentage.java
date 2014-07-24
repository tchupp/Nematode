package com.nematode.model;

public class ScanningTolerancePercentage {

	private int tolerancePercentageValue;

	public ScanningTolerancePercentage(int tolerancePercentageValue) {
		this.tolerancePercentageValue = tolerancePercentageValue;
	}

	public double getTolerancePercentageValue() {
		return 0.01 * this.tolerancePercentageValue;
	}

}
