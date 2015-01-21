package com.nematode.model;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoMatriarchTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class);
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoMatriarchInterface.class, VideoMatriarch.class);
	}

	@Test
	public void testGetVideoReturnsCorrectVideo() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		assertIsOfTypeAndGet(NullVideo.class, videoMatriarch.getVideo());

		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertSame(mockVideo, videoMatriarch.getVideo());
	}

	@Test
	public void testGrabCurrentFrameCallsGrabOnVideo_ReturnsCorrectFrame() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		final Mat expectedFrame = new Mat();
		mockVideo.setGrabMatToReturn(expectedFrame);

		assertFalse(mockVideo.wasGrabCalled());
		final Mat currentFrame = videoMatriarch.grabCurrentFrame();
		assertTrue(mockVideo.wasGrabCalled());

		assertSame(expectedFrame, currentFrame);
	}

	@Test
	public void testStartCallsStartOnVideo() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertFalse(mockVideo.wasStartCalled());
		videoMatriarch.startVideo();
		assertTrue(mockVideo.wasStartCalled());
	}

	@Test
	public void testStopCallsStopOnVideo() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertFalse(mockVideo.wasStopCalled());
		videoMatriarch.stopVideo();
		assertTrue(mockVideo.wasStopCalled());
	}
}
