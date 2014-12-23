package com.nematode.model;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NullVideoTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class);
	}

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoInterface.class, NullVideo.class);
	}

	@Test
	public void testGettingDimensionsReturnsNegativeOne() throws Exception {
		final NullVideo video = new NullVideo();

		assertEquals(-1, video.getHeight());
		assertEquals(-1, video.getWidth());
	}

	@Test
	public void testIsValidReturnsFalse() throws Exception {
		final NullVideo video = new NullVideo();

		assertFalse(video.isValid());
	}

	@Test
	public void testGetThumbnailReturnsEmptyMat() throws Exception {
		final NullVideo video = new NullVideo();

		video.start();

		final Mat frame = video.getThumbnail();

		assertEquals(0, frame.cols());
		assertEquals(0, frame.rows());
	}

	@Test
	public void testGrabbingAFrameReturnsEmptyMat() throws Exception {
		final NullVideo video = new NullVideo();

		video.start();

		final Mat frame = video.grab();

		assertEquals(0, frame.cols());
		assertEquals(0, frame.rows());
	}
}
