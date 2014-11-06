package com.nematode.model.factory;

import org.junit.Test;

import com.nematode.image.MockContourArea;
import com.nematode.image.MockContourAreaCalculator;
import com.nematode.image.MockContourLines;
import com.nematode.model.NematodeWormInterface;
import com.nematode.unittesting.AssertTestCase;

public class NematodeWormBuilderTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeWormBuilderInterface.class, NematodeWormBuilder.class);
	}

	@Test
	public void testGetsContourAreaCalculator() throws Exception {
		final MockContourAreaCalculator contourAreaCalculator = new MockContourAreaCalculator();
		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				contourAreaCalculator);

		assertSame(contourAreaCalculator, nematodeWormBuilder.getContourAreaCalculator());
	}

	@Test
	public void testBuildWormReturnsWormWithContourLines() throws Exception {
		final MockContourLines mockContourLines = new MockContourLines();

		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				new MockContourAreaCalculator());

		final NematodeWormInterface nematodeWorm = nematodeWormBuilder.buildWorm(mockContourLines);

		assertSame(mockContourLines, nematodeWorm.getContourLines());
	}

	@Test
	public void testBuildWormCallsGetAreaOnContourAreaCalculator() throws Exception {
		final MockContourArea mockContourArea = new MockContourArea();
		final MockContourAreaCalculator contourAreaCalculator = new MockContourAreaCalculator();
		contourAreaCalculator.setAreaToReturn(mockContourArea);

		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				contourAreaCalculator);

		assertFalse(contourAreaCalculator.wasGetAreaCalled());

		final NematodeWormInterface worm = nematodeWormBuilder.buildWorm(new MockContourLines());

		assertTrue(contourAreaCalculator.wasGetAreaCalled());
		assertSame(mockContourArea, worm.getContourArea());
	}
}
