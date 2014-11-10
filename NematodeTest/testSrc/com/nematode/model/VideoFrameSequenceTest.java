package com.nematode.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.gui.MockVideoFrame;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameSequenceTest extends AssertTestCase {
	@Test
	public void testVideoFrameSequenceImplemntsInterface() throws Exception {
		assertImplementsInterface(VideoFrameSequenceInterface.class, VideoFrameSequence.class);
	}

	@Test
	public void testGetsVideoFrameListPassedIn() throws Exception {
		final List<VideoFrameInterface> expectedVideoFrameList = new ArrayList<VideoFrameInterface>();
		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence(expectedVideoFrameList);
		assertSame(expectedVideoFrameList, videoFrameSequence.getVideoFrameList());
	}

	@Test
	public void testGetFrameReturnsCorrectVideoFrame_InsideIndex() throws Exception {
		final List<VideoFrameInterface> videoFrameList = new ArrayList<VideoFrameInterface>();
		final MockVideoFrame expectedVideoFrame = new MockVideoFrame();
		videoFrameList.add(expectedVideoFrame);

		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence(videoFrameList);
		assertSame(expectedVideoFrame, videoFrameSequence.getFrame(0));
	}

	@Test
	public void testGetFrameReturnsCorrectVideoFrame_OutsideIndex() throws Exception {
		final List<VideoFrameInterface> expectedVideoFrameList = new ArrayList<VideoFrameInterface>();
		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence(expectedVideoFrameList);

		final NullVideoFrame actualVideoFrame = assertIsOfTypeAndGet(NullVideoFrame.class,
				videoFrameSequence.getFrame(0));
		assertSame(NullVideoFrame.NULL, actualVideoFrame);
	}

	@Test
	public void testGetSizeReturnsCorrectSizeOfVideoFrameList() throws Exception {
		final List<VideoFrameInterface> videoFrameList = new ArrayList<VideoFrameInterface>();
		final VideoFrameSequence videoFrameSequence = new VideoFrameSequence(videoFrameList);

		assertEquals(0, videoFrameSequence.getSize());

		videoFrameList.add(new MockVideoFrame());
		videoFrameList.add(new MockVideoFrame());

		assertEquals(2, videoFrameSequence.getSize());
	}
}
