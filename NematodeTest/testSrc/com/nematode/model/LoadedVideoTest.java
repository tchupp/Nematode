package com.nematode.model;

import java.awt.image.BufferedImage;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class LoadedVideoTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoInterface.class, LoadedVideo.class);
	}

	@Test
	public void testGetsFrameGrabberPassedIn() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertSame(frameGrabber, video.getFrameGrabber());
	}

	@Test
	public void testGrabbingAFrameFromAVideoReturnsTheCorrectFrame() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");

		final LoadedVideo video = new LoadedVideo(frameGrabber);

		video.start();

		final OpenCVFrameGrabber realFrameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		realFrameGrabber.start();

		for (int i = 0; i < 2; i++) {
			final Mat actualFrame = video.grab();
			final Mat expectedFrame = new Mat(realFrameGrabber.grab());

			assertMatsAreEqual(expectedFrame, actualFrame);
		}
	}

	@Test
	public void testGrabbingAFrameFromEmptyVideoReturnsEmptyMat() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("");

		final LoadedVideo video = new LoadedVideo(frameGrabber);

		video.start();

		final Mat frame = video.grab();

		assertEquals(0, frame.cols());
		assertEquals(0, frame.rows());
	}

	@Test
	public void testGrabbingAFrameBeforeStartHasBeenCalledReturnsEmptyMat() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");

		final LoadedVideo video = new LoadedVideo(frameGrabber);

		final Mat frame = video.grab();

		assertEquals(0, frame.cols());
		assertEquals(0, frame.rows());
	}

	@Test
	public void testStopResetsTheVideo_CallsStopOnFrameGrabber() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);
		video.start();

		video.grab();
		video.grab();
		video.grab();

		video.stop();
		video.start();

		final Mat actualThumbnail = video.getThumbnail();

		final OpenCVFrameGrabber realFrameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");

		realFrameGrabber.start();

		final Mat expectedFirstFrame = new Mat(realFrameGrabber.grab());

		assertMatsAreEqual(expectedFirstFrame, actualThumbnail);
	}

	@Test
	public void testGetThumbnailReturnsEmptyMatForInvalidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("");

		final LoadedVideo video = new LoadedVideo(frameGrabber);

		final Mat frame = video.getThumbnail();

		assertEquals(0, frame.cols());
		assertEquals(0, frame.rows());
	}

	@Test
	public void testGetThumbnailReturnsFirstFrameOfVideo_RegardlessOfCurrentPosition()
			throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);
		video.start();

		final Mat actualFrame = video.grab();

		final OpenCVFrameGrabber realFrameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");

		realFrameGrabber.start();

		final Mat expectedFirstFrame = new Mat(realFrameGrabber.grab());

		assertMatsAreEqual(expectedFirstFrame, actualFrame);
	}

	@Test
	public void testGettingWidthAndHeightReturnCorrectDimensions_StartCalled_ValidVideo()
			throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		video.start();

		assertEquals(2200, video.getWidth());
		assertEquals(2054, video.getHeight());
	}

	@Test
	public void testGettingWidthAndHeightReturnZero_StartNotCalled_ValidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0, video.getWidth());
		assertEquals(0, video.getHeight());
	}

	@Test
	public void testGettingWidthAndHeightReturnZero_StartCalledThenStopCalled_ValidVideo()
			throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		video.start();
		video.stop();

		assertEquals(0, video.getWidth());
		assertEquals(0, video.getHeight());
	}

	@Test
	public void testGettingWidthAndHeightReturnZero_InvalidVideo() throws Exception {
		final OpenCVFrameGrabber emptyFrameGrabber = new OpenCVFrameGrabber("");
		final LoadedVideo video = new LoadedVideo(emptyFrameGrabber);

		video.start();

		assertEquals(0, video.getWidth());
		assertEquals(0, video.getHeight());
	}

	@Test
	public void testIsValidReturnsTrueForValidVideoFile_AVI() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertTrue(video.isValid());
	}

	@Test
	public void testIsValidReturnsTrueForValidVideoFile_MP4() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.mp4");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertTrue(video.isValid());
	}

	@Test
	public void testIsValidReturnsFalseForInvalidVideoFile() throws Exception {
		final OpenCVFrameGrabber emptyFrameGrabber = new OpenCVFrameGrabber("");
		final LoadedVideo video = new LoadedVideo(emptyFrameGrabber);

		assertFalse(video.isValid());
	}

	private void assertMatsAreEqual(final Mat expected, final Mat actual) {

		final BufferedImage actualImage = actual.getBufferedImage();
		final BufferedImage expectedImage = expected.getBufferedImage();

		final int height = expectedImage.getHeight();
		final int width = expectedImage.getWidth();
		assertEquals("Heights are different", height, actualImage.getHeight());
		assertEquals("Widths are different", width, actualImage.getWidth());

		for (int y = 0; y < actualImage.getHeight(); y++) {
			for (int x = 0; x < actualImage.getWidth(); x++) {
				assertEquals(expectedImage.getRGB(x, y), actualImage.getRGB(x, y));
			}
		}
	}
}
