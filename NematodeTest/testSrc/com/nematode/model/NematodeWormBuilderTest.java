package com.nematode.model;

import org.junit.Test;

import com.nematode.imaging.MockContourLines;
import com.nematode.unittesting.AssertTestCase;

public class NematodeWormBuilderTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeWormBuilderInterface.class,
				NematodeWormBuilder.class);
	}

	@Test
	public void testBuildWormReturnsWormWithContourLines() throws Exception {
		final MockContourLines mockContourLines = new MockContourLines();
		final NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder();
		final NematodeWormInterface nematodeWorm = nematodeWormBuilder
				.buildWorm(mockContourLines);
		assertSame(mockContourLines, nematodeWorm.getContourLines());
	}
}
