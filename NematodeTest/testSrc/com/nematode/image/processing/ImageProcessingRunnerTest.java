package com.nematode.image.processing;

import org.junit.Test;

import com.nematode.gui.MockVideoFrame;
import com.nematode.image.ProcessedFrameImage;
import com.nematode.image.processing.ImageProcessingRunner;
import com.nematode.image.MockImageProcessingHelper;
import com.nematode.image.processing.ImageProcessingRunnerInterface;
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
		final MockVideoFrame videoFrame = new MockVideoFrame();
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
		final MockVideoFrame videoFrame = new MockVideoFrame();

		final MockImageProcessingHelper imageProcessingHelper = new MockImageProcessingHelper();
		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				imageProcessingHelper);

		assertFalse(imageProcessingHelper.wasDrawObjectsOnNewImageCalled());

		imageProcessingRunner
		.createImageWithIdentifiedObjects(videoFrame);

		assertTrue(imageProcessingHelper.wasDrawObjectsOnNewImageCalled());
		assertSame(videoFrame.getVideoFrameImage().getImage(),
				imageProcessingHelper.getBaseImageToDraw());
		assertSame(videoFrame.getObjectsOnImage(),
				imageProcessingHelper.getObjectsToDraw());

	}
}
