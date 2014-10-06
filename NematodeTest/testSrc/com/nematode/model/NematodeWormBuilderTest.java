package com.nematode.model;

import org.junit.Test;

import com.nematode.imaging.MockContourAreaCalculator;
import com.nematode.imaging.MockContourLines;
import com.nematode.unittesting.AssertTestCase;

public class NematodeWormBuilderTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeWormBuilderInterface.class,
				NematodeWormBuilder.class);
	}

	@Test
	public void testGetsContourAreaCalculator() throws Exception {
		final MockContourAreaCalculator contourAreaCalculator = new MockContourAreaCalculator();
		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				contourAreaCalculator);

		assertSame(contourAreaCalculator,
				nematodeWormBuilder.getContourAreaCalculator());
	}

	@Test
	public void testBuildWormReturnsWormWithContourLines() throws Exception {
		final MockContourLines mockContourLines = new MockContourLines();
		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				new MockContourAreaCalculator());
		final NematodeWormInterface nematodeWorm = nematodeWormBuilder
				.buildWorm(mockContourLines);
		assertSame(mockContourLines, nematodeWorm.getContourLines());
	}

	@Test
	public void testBuildWormCallsGetAreaPointsOnAreaCalculator()
			throws Exception {
		final MockContourAreaCalculator contourAreaCalculator = new MockContourAreaCalculator();
		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				contourAreaCalculator);

		assertFalse(contourAreaCalculator.wasGetAreaCalled());

		final NematodeWormInterface worm = nematodeWormBuilder
				.buildWorm(new MockContourLines());

		assertTrue(contourAreaCalculator.wasGetAreaCalled());
		assertNotNull(worm.getContourArea());
	}
}
