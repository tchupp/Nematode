package com.nematode.model;

import java.util.HashMap;

import org.junit.Test;

import com.nematode.gui.MockVideoFrame;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameSequenceTest extends AssertTestCase {
	@Test
	public void testVideoFrameSequenceImplemntsInterface() throws Exception {
		assertImplementsInterface(VideoFrameSequenceInterface.class, VideoFrameSequence.class);
	}

	@Test
	public void testVideoFrameSequenceInitializedWithEmptyMap() throws Exception {
		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence();
		assertEquals(0, videoFrameSequence.getVideoFrameMap().size());
	}

	@Test
	public void testAddingVideoFrameCorrectlyInsertsFrameIntoMap_AndCorrectlyUpdatesSize()
			throws Exception {
		final Integer videoFrameIndex = new Integer(5);
		final MockVideoFrame expectedVideoFrame = new MockVideoFrame();

		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence();

		assertEquals(0, videoFrameSequence.size());

		videoFrameSequence.addVideoFrame(videoFrameIndex, expectedVideoFrame);

		assertEquals(1, videoFrameSequence.size());

		final HashMap<Integer, VideoFrameInterface> actualVideoFrameMap = videoFrameSequence
				.getVideoFrameMap();
		assertSame(expectedVideoFrame, actualVideoFrameMap.get(videoFrameIndex));
	}

	@Test
	public void testGetVideoFrameReturnsCorrectVideoFrame_ValidIndex() throws Exception {
		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence();

		final Integer videoFrameIndex = new Integer(5);
		final MockVideoFrame expectedVideoFrame = new MockVideoFrame();
		videoFrameSequence.addVideoFrame(videoFrameIndex, expectedVideoFrame);

		final VideoFrameInterface actualVideoFrame = videoFrameSequence
				.getVideoFrame(videoFrameIndex);
		assertSame(expectedVideoFrame, actualVideoFrame);
	}

	@Test
	public void testGetVideoFrameReturnsCorrectNullVideoFrame_InvalidIndex() throws Exception {
		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence();

		final Integer otherVideoFrameIndex = new Integer(7);
		final Integer videoFrameIndex = new Integer(5);
		final MockVideoFrame expectedVideoFrame = new MockVideoFrame();
		videoFrameSequence.addVideoFrame(videoFrameIndex, expectedVideoFrame);

		assertIsOfTypeAndGet(NullVideoFrame.class,
				videoFrameSequence.getVideoFrame(otherVideoFrameIndex));
	}

	@Test
	public void testVideoFrameSequenceWithNoVideoFramesReturnsTrueForIsEmpty_FalseIfThereAreVideoFrames()
			throws Exception {
		final Integer videoFrameIndex = new Integer(5);
		final MockVideoFrame expectedVideoFrame = new MockVideoFrame();

		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence();

		assertTrue(videoFrameSequence.isEmpty());

		videoFrameSequence.addVideoFrame(videoFrameIndex, expectedVideoFrame);

		assertFalse(videoFrameSequence.isEmpty());
	}

	@Test
	public void testClearRemovesAllVideoFramesFromTheSequence() throws Exception {
		final Integer videoFrameIndex = new Integer(5);
		final MockVideoFrame expectedVideoFrame = new MockVideoFrame();

		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence();

		videoFrameSequence.addVideoFrame(videoFrameIndex, expectedVideoFrame);

		assertFalse(videoFrameSequence.isEmpty());

		videoFrameSequence.clear();

		assertTrue(videoFrameSequence.isEmpty());
	}
}
