package com.nematode.model;

import com.nematode.imaging.ContourPointsInterface;

public class NematodeWormBuilder implements NematodeWormBuilderInterface {

	@Override
	public NematodeWormInterface buildWorm(
			final ContourPointsInterface contourPoints) {

		final NematodeWorm nematodeWorm = new NematodeWorm(contourPoints);

		return nematodeWorm;
	}
}