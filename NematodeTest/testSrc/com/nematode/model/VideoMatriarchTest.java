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
	public void testStartVideoCallsStartOnVideo() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertFalse(mockVideo.wasStartCalled());
		videoMatriarch.startVideo();
		assertTrue(mockVideo.wasStartCalled());
	}

	@Test
	public void testStopVideoCallsStopOnVideo() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertFalse(mockVideo.wasStopCalled());
		videoMatriarch.stopVideo();
		assertTrue(mockVideo.wasStopCalled());
	}

	@Test
	public void testStartSetsIsRunningToTrue_StopVideoSetsIsRunningToFalse() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);

		assertFalse(videoMatriarch.isRunning());
		videoMatriarch.startVideo();
		assertTrue(videoMatriarch.isRunning());
		videoMatriarch.stopVideo();
		assertFalse(videoMatriarch.isRunning());
	}

	@Test
	public void testCurrentFrameNumberStartsAtOne_IncreasedByGrabCurrentFrame() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		assertEquals(1, videoMatriarch.getCurrentFrameNumber());
		videoMatriarch.grabCurrentFrame();
		assertEquals(2, videoMatriarch.getCurrentFrameNumber());
		videoMatriarch.grabCurrentFrame();
		assertEquals(3, videoMatriarch.getCurrentFrameNumber());
	}

	@Test
	public void testStartVideoAndStopVideoSetCurrentFrameNumberToOne() throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();

		videoMatriarch.grabCurrentFrame();
		videoMatriarch.grabCurrentFrame();
		assertEquals(3, videoMatriarch.getCurrentFrameNumber());

		videoMatriarch.startVideo();
		assertEquals(1, videoMatriarch.getCurrentFrameNumber());

		videoMatriarch.grabCurrentFrame();
		videoMatriarch.grabCurrentFrame();
		assertEquals(3, videoMatriarch.getCurrentFrameNumber());

		videoMatriarch.stopVideo();
		assertEquals(1, videoMatriarch.getCurrentFrameNumber());
	}

	@Test
	public void testIfGrabCurrentFramePutsCurrentFrameNumberHigherThanVideosFrameLength_IsRunningSetToFalse()
			throws Exception {
		final VideoMatriarch videoMatriarch = new VideoMatriarch();
		final MockVideo mockVideo = new MockVideo();
		videoMatriarch.setVideo(mockVideo);
		mockVideo.setFrameLengthToReturn(4);

		videoMatriarch.startVideo();
		videoMatriarch.grabCurrentFrame();
		assertEquals(2, videoMatriarch.getCurrentFrameNumber());
		assertTrue(videoMatriarch.isRunning());

		videoMatriarch.grabCurrentFrame();
		assertEquals(3, videoMatriarch.getCurrentFrameNumber());
		assertFalse(videoMatriarch.isRunning());
	}
}
