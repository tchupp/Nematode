package com.nematode.model;

import java.util.Map;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoInfoMatriarchTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoInfoMatriarchInterface.class, VideoInfoMatriarch.class);
	}

	@Test
	public void testMatriarchIsConstructedWithEmptyVideoSequence() throws Exception {
		final VideoInfoMatriarch videoInfoMatriarch = new VideoInfoMatriarch();

		final VideoFrameSequence videoFrameSequence = assertIsOfTypeAndGet(
				VideoFrameSequence.class, videoInfoMatriarch.getVideoFrameSequence());

		assertTrue(videoFrameSequence.isEmpty());
	}

	@Test
	public void testMatriarchIsConstructedWithEmptyVideoFrameInfoMap() throws Exception {
		final VideoInfoMatriarch videoInfoMatriarch = new VideoInfoMatriarch();
		final Map<VideoFrameInterface, VideoFrameInfoInterface> videoFrameInfoMap = videoInfoMatriarch
				.getVideoFrameInfoMap();

		assertTrue(videoFrameInfoMap.isEmpty());
	}
}
