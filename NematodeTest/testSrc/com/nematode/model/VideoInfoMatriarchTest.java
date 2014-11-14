package com.nematode.model;

import java.util.Map;

import org.junit.Test;

import com.nematode.fileIO.VideoFrameAssembler;
import com.nematode.model.factory.FrameImageAssembler;
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

	@Test
	public void testMatriarchConstructsVideoFrameAssemblerWithCorrectSequence_AndAssembler()
			throws Exception {
		final VideoInfoMatriarch videoInfoMatriarch = new VideoInfoMatriarch();
		final VideoFrameAssembler videoFrameAssembler = videoInfoMatriarch.getVideoFrameAssembler();

		assertSame(videoInfoMatriarch.getVideoFrameSequence(),
				videoFrameAssembler.getVideoFrameSequence());

		assertIsOfTypeAndGet(FrameImageAssembler.class, videoInfoMatriarch.getVideoFrameAssembler()
				.getFrameImageAssembler());
	}
}
