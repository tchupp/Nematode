package com.nematode.model;

import org.junit.Test;

import com.nematode.imaging.MockContourPoints;
import com.nematode.unittesting.AssertTestCase;

public class NematodeWormTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeWormInterface.class,
				NematodeWorm.class);
	}

	@Test
	public void testGetsContourPoints() throws Exception {
		final MockContourPoints expectedContourPoints = new MockContourPoints();
		final NematodeWorm nematodeWorm = new NematodeWorm(
				expectedContourPoints);
		assertSame(expectedContourPoints, nematodeWorm.getContourPoints());
	}
}
