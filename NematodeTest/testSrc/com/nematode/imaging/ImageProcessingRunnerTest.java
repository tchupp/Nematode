package com.nematode.imaging;

import java.awt.image.BufferedImage;

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
	public void testScanVideoFrameOverlaysScannedImageOnVideoFrame()
			throws Exception {

		final MockImageProcessingHelper mockImageProcessingHelper = new MockImageProcessingHelper();
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();

		final BufferedImage expectedBaseImage = videoFrame.getVideoFrameImage()
				.getImage();
		final BufferedImage expectedTopImage = videoFrame
				.getScannedFrameImage().getImage();

		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				mockImageProcessingHelper);

		assertFalse(mockImageProcessingHelper.wasOverlayImageCalled());
		assertFalse(videoFrame.wasSetScannedFrameImageCalled());
		imageProcessingRunner.scanVideoFrame(videoFrame);
		assertTrue(mockImageProcessingHelper.wasOverlayImageCalled());
		assertTrue(videoFrame.wasSetScannedFrameImageCalled());

		assertSame(expectedBaseImage,
				mockImageProcessingHelper.getBaseImageToOverlay());
		assertSame(expectedTopImage,
				mockImageProcessingHelper.getTopImageToOverlay());

	}

	@Test
	public void testPreprocessImageForScanningCorrectlySetsBlackAndWhiteImageToScan()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockImageProcessingHelper mockImageProcessingHelper = new MockImageProcessingHelper();

		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				mockImageProcessingHelper);

		assertFalse(videoFrame.wasSetScannedFrameImageCalled());

		assertFalse(mockImageProcessingHelper
				.wasConvertImageToGreyScaleCalled());
		assertFalse(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());

		imageProcessingRunner.preprocessImageForScanning(videoFrame);

		assertTrue(videoFrame.wasSetScannedFrameImageCalled());

		assertTrue(mockImageProcessingHelper.wasConvertImageToGreyScaleCalled());
		assertTrue(mockImageProcessingHelper
				.wasConvertImageToBlackAndWhiteCalled());
	}
}
