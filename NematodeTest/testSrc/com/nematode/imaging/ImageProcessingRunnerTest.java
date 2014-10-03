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

		assertFalse(videoFrame.wasSetProcessedFrameImageCalled());

		assertFalse(mockImageProcessingHelper
				.wasConvertImageToGreyScaleCalled());
		assertFalse(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());

		imageProcessingRunner.preprocessImageForScanning(videoFrame);

		assertTrue(videoFrame.wasSetProcessedFrameImageCalled());

		assertTrue(mockImageProcessingHelper.wasConvertImageToGreyScaleCalled());
		assertTrue(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());
	}
}
