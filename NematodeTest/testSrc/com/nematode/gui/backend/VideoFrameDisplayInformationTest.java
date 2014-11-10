package com.nematode.gui.backend;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoFrameDisplayInformationTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameDisplayInformationInterface.class,
				VideoFrameDisplayInformation.class);
	}

	@Test
	public void testGetsFrameNumberPassedIn() throws Exception {
		VideoFrameDisplayInformation displayInformation = new VideoFrameDisplayInformation(0);
		assertEquals(0, displayInformation.getFrameNumber());

		displayInformation = new VideoFrameDisplayInformation(3);
		assertEquals(3, displayInformation.getFrameNumber());
	}

}
