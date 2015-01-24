package com.nematode.model;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class LoadedVideoTest extends AssertTestCase {

	@Override
	protected void setUp() throws Exception {
		Loader.load(org.bytedeco.javacpp.opencv_core.class);
	}

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

			assertImagesAreEqual(expectedFrame.getBufferedImage(), actualFrame.getBufferedImage());
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

		assertImagesAreEqual(expectedFirstFrame.getBufferedImage(),
				actualThumbnail.getBufferedImage());
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

		video.grab();
		video.grab();

		final Mat actualFrame = video.getThumbnail();

		final OpenCVFrameGrabber realFrameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");

		realFrameGrabber.start();

		final Mat expectedFirstFrame = new Mat(realFrameGrabber.grab());

		assertImagesAreEqual(expectedFirstFrame.getBufferedImage(), actualFrame.getBufferedImage());
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
	public void testGettingWidthAndHeightReturnCorrectValue_StartNotCalled_ValidVideo()
			throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(2200, video.getWidth());
		assertEquals(2054, video.getHeight());
	}

	@Test
	public void testGettingWidthAndHeightReturnCorrectValue_StartCalledThenStopCalled_ValidVideo()
			throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.avi");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		video.start();
		video.stop();

		assertEquals(2200, video.getWidth());
		assertEquals(2054, video.getHeight());
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

	@Test
	public void testGetFrameRateReturnsCorrectValue_ValidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.mp4");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(31.0, video.getFrameRate());
	}

	@Test
	public void testGetFrameRateReturnsZero_InvalidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0.0, video.getFrameRate());
	}

	@Test
	public void testGetDurrationReturnsCorrectValue_ValidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.mp4");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0, video.getDurration());

		video.start();

		assertEquals(4354839, video.getDurration());
	}

	@Test
	public void testGetDurrationReturnsZero_InvalidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0, video.getDurration());

		video.start();

		assertEquals(0, video.getDurration());
	}

	@Test
	public void testGetFrameLengthReturnsCorrectValue_ValidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.mp4");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0, video.getFrameLength());

		video.start();

		assertEquals(135, video.getFrameLength());
	}

	@Test
	public void testGetFrameLengthReturnsZero_InvalidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0, video.getFrameLength());

		video.start();

		assertEquals(0, video.getFrameLength());
	}

	@Test
	public void testGetCurrentFrameReturnsCorrectValue_ValidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(
				"testResources/Videos/shortNematode_10.mp4");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0, video.getCurrentFrame());
		video.start();
		assertEquals(2, video.getCurrentFrame());
		video.grab();
		assertEquals(3, video.getCurrentFrame());
		video.grab();
		assertEquals(4, video.getCurrentFrame());
	}

	@Test
	public void testGetCurrentFrameReturnsZero_InvalidVideo() throws Exception {
		final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("");
		final LoadedVideo video = new LoadedVideo(frameGrabber);

		assertEquals(0, video.getCurrentFrame());

		video.start();

		assertEquals(0, video.getCurrentFrame());
	}
}
