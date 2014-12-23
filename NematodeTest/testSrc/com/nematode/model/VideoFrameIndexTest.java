package com.nematode.model;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class VideoFrameIndexTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameIndexInterface.class, VideoFrameIndex.class);
	}

	@Test
	public void testGetsIndexIntegerPassedIn() throws Exception {
		final int expectedIndex = 4;
		final VideoFrameIndex videoFrameIndex = new VideoFrameIndex(4);

		assertEquals(expectedIndex, videoFrameIndex.getIndex());
	}

	@Test
	public void testEqualsMethodReturnsTrueForEqualIndex() throws Exception {
		final int index = 5;
		final VideoFrameIndex videoFrameIndexOne = new VideoFrameIndex(index);
		final VideoFrameIndex videoFrameIndexTwo = new VideoFrameIndex(index);

		assertEquals(videoFrameIndexOne, videoFrameIndexTwo);
	}

	@Test
	public void testEqualsMethodReturnsFalseForDifferentIndex() throws Exception {
		final int indexOne = 4;
		final int indexTwo = 5;
		final VideoFrameIndex videoFrameIndexOne = new VideoFrameIndex(indexOne);
		final VideoFrameIndex videoFrameIndexTwo = new VideoFrameIndex(indexTwo);

		assertNotEquals(videoFrameIndexOne, videoFrameIndexTwo);
	}
}
