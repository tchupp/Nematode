package com.nematode.model.factory;

import com.nematode.image.detection.ContourLinesInterface;
import com.nematode.model.NematodeWormInterface;

public interface NematodeWormBuilderInterface {

	public NematodeWormInterface buildWorm(ContourLinesInterface contourLines);

}
