package com.nematode.model;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoFrameInfoTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameInfoInterface.class, VideoFrameInfo.class);
	}

}
