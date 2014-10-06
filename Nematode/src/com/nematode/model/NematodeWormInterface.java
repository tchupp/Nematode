package com.nematode.model;

import com.nematode.imaging.ContourAreaInterface;
import com.nematode.imaging.ContourLinesInterface;

public interface NematodeWormInterface {

	public ContourLinesInterface getContourLines();

	public ContourAreaInterface getContourArea();

}
