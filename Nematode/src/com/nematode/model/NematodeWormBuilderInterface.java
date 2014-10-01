package com.nematode.model;

import com.nematode.imaging.ContourPointsInterface;

public interface NematodeWormBuilderInterface {

	public NematodeWormInterface buildWorm(
			ContourPointsInterface contourPoints);

}
