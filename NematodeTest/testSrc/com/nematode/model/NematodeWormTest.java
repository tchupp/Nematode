package com.nematode.model;

import org.junit.Test;

import com.nematode.image.MockContourArea;
import com.nematode.image.MockContourLines;
import com.nematode.image.detection.NullContourArea;
import com.nematode.unittesting.AssertTestCase;

public class NematodeWormTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodeWormInterface.class, NematodeWorm.class);
	}

	@Test
	public void testGetsContourLines() throws Exception {
		final MockContourLines expectedContourLines = new MockContourLines();
		final NematodeWorm nematodeWorm = new NematodeWorm(expectedContourLines);

		assertSame(expectedContourLines, nematodeWorm.getContourLines());
	}

	@Test
	public void testGetsDefaultContourArea_And_SetContourArea() throws Exception {
		final NematodeWorm nematodeWorm = new NematodeWorm(new MockContourLines());

		assertIsOfTypeAndGet(NullContourArea.class, nematodeWorm.getContourArea());

		final MockContourArea mockContourArea = new MockContourArea();
		nematodeWorm.setContourArea(mockContourArea);

		assertSame(mockContourArea, nematodeWorm.getContourArea());
	}
}
