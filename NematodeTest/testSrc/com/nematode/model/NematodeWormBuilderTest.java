package com.nematode.model;

import org.junit.Test;

import com.nematode.imaging.MockContourPoints;
import com.nematode.unittesting.AssertTestCase;

public class NematodeWormBuilderTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeWormBuilderInterface.class,
				NematodeWormBuilder.class);
	}

	@Test
	public void testBuildWormReturnsWormWithContourPoints() throws Exception {
		final MockContourPoints mockContourPoints = new MockContourPoints();
		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder();
		final NematodeWormInterface nematodeWorm = nematodeWormBuilder
				.buildWorm(mockContourPoints);
		assertSame(mockContourPoints, nematodeWorm.getContourPoints());
	}
}
