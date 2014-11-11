package com.nematode.gui.backend;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoFrameDisplayInfoTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameDisplayInfoInterface.class,
				VideoFrameDisplayInfo.class);
	}

	@Test
	public void testGetsFrameNumberPassedIn() throws Exception {
		VideoFrameDisplayInfo displayInfo = new VideoFrameDisplayInfo(0);
		assertEquals(0, displayInfo.getFrameNumber());

		displayInfo = new VideoFrameDisplayInfo(3);
		assertEquals(3, displayInfo.getFrameNumber());
	}

}
