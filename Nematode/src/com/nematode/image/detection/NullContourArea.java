package com.nematode.image.detection;

import java.util.ArrayList;
import java.util.List;

public class NullContourArea implements ContourAreaInterface {

	@Override
	public List<InnerPointInterface> getListOfInnerPoints() {
		return new ArrayList<InnerPointInterface>();
	}

	@Override
	public int getSize() {
		return -1;
	}

}
