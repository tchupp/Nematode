package com.nematode.imaging;

import java.util.ArrayList;
import java.util.List;

public class MockContourArea implements ContourAreaInterface {

	private ArrayList<InnerPointInterface> listOfInnerPoints = new ArrayList<InnerPointInterface>();
	int size = 0;

	@Override
	public List<InnerPointInterface> getListOfInnerPoints() {
		return this.listOfInnerPoints;
	}

	public void setListOfInnerPoints(
			final ArrayList<InnerPointInterface> listOfInnerPoints) {
		this.listOfInnerPoints = listOfInnerPoints;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	public void setSize(final int sizeToReturn) {
		this.size = sizeToReturn;
	}
}
