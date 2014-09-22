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
	public void testScanVideoFrameSetsNewScannedImageOnVideoFrame()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockImageProcessingHelper mockImageProcessingHelper = new MockImageProcessingHelper();

		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				mockImageProcessingHelper);

		final ScannedFrameImageInterface firstScannedFrameImage = videoFrame
				.getScannedFrameImage();

		assertFalse(mockImageProcessingHelper
				.wasConvertImageToGreyScaleCalled());
		assertFalse(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());

		imageProcessingRunner.scanVideoFrame(videoFrame);

		assertTrue(mockImageProcessingHelper.wasConvertImageToGreyScaleCalled());
		assertTrue(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());

		assertNotSame(firstScannedFrameImage, videoFrame.getScannedFrameImage());
	}
}
