package com.nematode.imaging;

import org.junit.Test;

import com.nematode.gui.MockNematodeVideoFrame;
import com.nematode.unittesting.AssertTestCase;

public class ImageProcessingRunnerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ImageProcessingRunnerInterface.class,
				ImageProcessingRunner.class);
	}

	@Test
	public void testGetsImageProcessingHelper() throws Exception {
		final MockImageProcessingHelper mockImageProcessingHelper = new MockImageProcessingHelper();
		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				mockImageProcessingHelper);

		assertSame(mockImageProcessingHelper,
				imageProcessingRunner.getImageProcessingHelper());
	}

	@Test
	public void testPreprocessImageForScanningCorrectlySetsBlackAndWhiteImageToScan()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockImageProcessingHelper mockImageProcessingHelper = new MockImageProcessingHelper();

		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				mockImageProcessingHelper);

		assertFalse(mockImageProcessingHelper
				.wasConvertImageToGreyScaleCalled());
		assertFalse(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());

		assertIsOfTypeAndGet(ProcessedFrameImage.class,
				imageProcessingRunner.preprocessImageForScanning(videoFrame));

		assertTrue(mockImageProcessingHelper.wasConvertImageToGreyScaleCalled());
		assertTrue(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());
	}

	@Test
	public void testCreateImageWithObjectsCallsDrawObjectsOnImageProcessingHelper()
			throws Exception {
		final MockNematodeVideoFrame nematodeVideoFrame = new MockNematodeVideoFrame();

		final MockImageProcessingHelper imageProcessingHelper = new MockImageProcessingHelper();
		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				imageProcessingHelper);

		assertFalse(imageProcessingHelper.wasDrawObjectsOnNewImageCalled());

		imageProcessingRunner
		.createImageWithIdentifiedObjects(nematodeVideoFrame);

		assertTrue(imageProcessingHelper.wasDrawObjectsOnNewImageCalled());
		assertSame(nematodeVideoFrame.getVideoFrameImage().getImage(),
				imageProcessingHelper.getBaseImageToDraw());
		assertSame(nematodeVideoFrame.getObjectsOnImage(),
				imageProcessingHelper.getObjectsToDraw());

	}
}
