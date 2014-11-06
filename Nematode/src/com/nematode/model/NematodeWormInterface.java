package com.nematode.model;

import com.nematode.image.detection.ContourAreaInterface;
import com.nematode.image.detection.ContourLinesInterface;

public interface NematodeWormInterface {

	public ContourLinesInterface getContourLines();

	public ContourAreaInterface getContourArea();

	void setContourArea(ContourAreaInterface contourArea);

}
