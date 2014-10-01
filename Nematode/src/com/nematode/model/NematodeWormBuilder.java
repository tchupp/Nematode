package com.nematode.model;

import com.nematode.imaging.ContourLinesInterface;

public class NematodeWormBuilder implements NematodeWormBuilderInterface {

	@Override
	public NematodeWormInterface buildWorm(
			final ContourLinesInterface contourLines) {

		final NematodeWorm nematodeWorm = new NematodeWorm(contourLines);

		return nematodeWorm;
	}
}