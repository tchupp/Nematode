package com.nematode.image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.nematode.image.detection.ContourLinesInterface;
import com.nematode.image.detection.SquareContourTracerInterface;

public class MockSquareContourTracer implements SquareContourTracerInterface {

	private boolean getFirstContourLinesWasCalled = false;

	private List<ContourLinesInterface> listOfLinesToReturn = new ArrayList<ContourLinesInterface>();

	private BufferedImage scannedImage;

	@Override
	public ContourLinesInterface getFirstContourLines(final BufferedImage image) {
		this.scannedImage = image;
		this.getFirstContourLinesWasCalled = true;

		final ContourLinesInterface contourLineToReturn = this.listOfLinesToReturn
				.get(0);
		this.listOfLinesToReturn.remove(0);

		return contourLineToReturn;
	}

	public boolean wasGetFirstContourLinesCalled() {
		return this.getFirstContourLinesWasCalled;
	}

	public void setListOfLinesToReturn(
			final List<ContourLinesInterface> listOfLinesToReturn) {
		this.listOfLinesToReturn = listOfLinesToReturn;
	}

	public BufferedImage getScannedImage() {
		return this.scannedImage;
	}
}
