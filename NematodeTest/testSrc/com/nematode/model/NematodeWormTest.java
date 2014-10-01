package com.nematode.model;

import org.junit.Test;

import com.nematode.imaging.MockContourLines;
import com.nematode.unittesting.AssertTestCase;

public class NematodeWormTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeWormInterface.class,
				NematodeWorm.class);
	}

	@Test
	public void testGetsContourLines() throws Exception {
		final MockContourLines expectedContourLines = new MockContourLines();
		final NematodeWorm nematodeWorm = new NematodeWorm(expectedContourLines);
		assertSame(expectedContourLines, nematodeWorm.getContourLines());
	}
}
