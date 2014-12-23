package com.nematode.model;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoMatriarchTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoMatriarchInterface.class, VideoMatriarch.class);
	}

	@Test
	public void testGetVideoReturnsCorrectVideo() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		final VideoInterface initialVideo = videoMatriarch.getVideo();
		assertIsOfTypeAndGet(NullVideo.class, initialVideo);

		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertSame(mockVideo, videoMatriarch.getVideo());
	}
}
