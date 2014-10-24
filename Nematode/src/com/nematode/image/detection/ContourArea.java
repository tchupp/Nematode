package com.nematode.image.detection;

import java.util.ArrayList;
import java.util.List;

public class ContourArea implements ContourAreaInterface {

	private List<InnerPointInterface> listOfInnerPoints = new ArrayList<InnerPointInterface>();

	public ContourArea(final List<InnerPointInterface> innerPoints) {
		this.listOfInnerPoints = innerPoints;
	}

	@Override
	public List<InnerPointInterface> getListOfInnerPoints() {
		return this.listOfInnerPoints;
	}

	@Override
	public int getSize() {
		return this.listOfInnerPoints.size();
	}
}
