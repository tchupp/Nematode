package com.nematode.imaging;

import org.junit.Test;

import com.nematode.fileIO.MockValidatedImageFile;
import com.nematode.gui.MockNematodeVideoFrame;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.nullmodel.NullFrameImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameHandlerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameHandlerInterface.class,
				VideoFrameHandler.class);
	}

	@Test
	public void testGetsNematodeVideoFrame() throws Exception {
		final MockNematodeVideoFrame expectedNematodeVideoFrame = new MockNematodeVideoFrame();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				expectedNematodeVideoFrame, new MockFrameImageAssembler(),
				new MockImageProcessingRunner(), new MockEdgeDetectionRunner());

		final NematodeVideoFrameInterface actualNematodeVideoFrame = videoFrameHandler
				.getNematodeVideoFrame();
		assertSame(expectedNematodeVideoFrame, actualNematodeVideoFrame);
	}

	@Test
	public void testGetsFrameImageAssembler() throws Exception {
		final MockFrameImageAssembler expectedFrameImageAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				new MockNematodeVideoFrame(), expectedFrameImageAssembler,
				new MockImageProcessingRunner(), new MockEdgeDetectionRunner());

		assertSame(expectedFrameImageAssembler,
				videoFrameHandler.getFrameImageAssembler());
	}

	@Test
	public void testGetsImageProcessingRunner() throws Exception {
		final MockImageProcessingRunner expectedImageProcessingRunner = new MockImageProcessingRunner();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				new MockNematodeVideoFrame(), new MockFrameImageAssembler(),
				expectedImageProcessingRunner, new MockEdgeDetectionRunner());

		assertSame(expectedImageProcessingRunner,
				videoFrameHandler.getImageProcessingRunner());
	}

	@Test
	public void testGetsEdgeDetectionRunner() throws Exception {
		final MockEdgeDetectionRunner edgeDetectionRunner = new MockEdgeDetectionRunner();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				new MockNematodeVideoFrame(), new MockFrameImageAssembler(),
				new MockImageProcessingRunner(), edgeDetectionRunner);

		assertSame(edgeDetectionRunner,
				videoFrameHandler.getEdgeDetectionRunner());
	}

	@Test
	public void testUpdateDisplayImageFromScannedImageSetsNewDisplayImageOnFrame()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockFrameImageAssembler mockAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				videoFrame, mockAssembler, new MockImageProcessingRunner(),
				new MockEdgeDetectionRunner());

		assertFalse(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertFalse(videoFrame.wasSetDisplayFrameImageCalled());
		videoFrameHandler.updateDisplayImageFromScannedImage();
		assertTrue(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertTrue(videoFrame.wasSetDisplayFrameImageCalled());
	}

	@Test
	public void testBuildNewFrameImage_WithValidImage_CallsCreateFromFrameAssembler()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockFrameImageAssembler mockAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				videoFrame, mockAssembler, new MockImageProcessingRunner(),
				new MockEdgeDetectionRunner());

		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		mockValidatedImageFile.setIsFileValid(true);

		assertFalse(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertFalse(mockAssembler.wasCreateVideoFrameImageCalled());
		videoFrameHandler.buildNewFrameImageFromFile(mockValidatedImageFile);
		assertTrue(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertTrue(mockAssembler.wasCreateVideoFrameImageCalled());
	}

	@Test
	public void testBuildNewFrameImage_WithInvalidImage_DoesntCallCreateFromFrameAssembler()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockFrameImageAssembler mockAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				videoFrame, mockAssembler, new MockImageProcessingRunner(),
				new MockEdgeDetectionRunner());

		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		mockValidatedImageFile.setIsFileValid(false);

		assertFalse(videoFrame.wasSetVideoFrameImageCalled());
		assertFalse(videoFrame.wasSetDisplayFrameImageCalled());

		assertFalse(mockAssembler.wasCreateVideoFrameImageCalled());
		assertFalse(mockAssembler.wasCreateDisplayFrameImageCalled());

		videoFrameHandler.buildNewFrameImageFromFile(mockValidatedImageFile);

		assertFalse(mockAssembler.wasCreateVideoFrameImageCalled());
		assertFalse(mockAssembler.wasCreateDisplayFrameImageCalled());

		assertTrue(videoFrame.wasSetVideoFrameImageCalled());
		assertTrue(videoFrame.wasSetDisplayFrameImageCalled());

		assertIsOfTypeAndGet(NullFrameImage.class,
				videoFrame.getVideoFrameImage());
		assertIsOfTypeAndGet(NullFrameImage.class,
				videoFrame.getDisplayFrameImage());
	}

	@Test
	public void testScanImageCallsImageProcessingRunnerWithVideoFrame_CorrectOrder()
			throws Exception {
		final MockImageProcessingRunner imageProcessingRunner = new MockImageProcessingRunner();
		final MockEdgeDetectionRunner edgeDetectionRunner = new MockEdgeDetectionRunner();

		final MockNematodeVideoFrame nematodeVideoFrame = new MockNematodeVideoFrame();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				nematodeVideoFrame, new MockFrameImageAssembler(),
				imageProcessingRunner, edgeDetectionRunner);

		assertFalse(imageProcessingRunner.wasPreprocessImageForScanningCalled());
		assertFalse(edgeDetectionRunner.wasFindAllObjectsInImageCalled());

		videoFrameHandler.scanImage();

		assertTrue(imageProcessingRunner.wasPreprocessImageForScanningCalled());
		assertSame(nematodeVideoFrame,
				imageProcessingRunner.getUnprocessedVideoFrame());

		assertTrue(edgeDetectionRunner.wasFindAllObjectsInImageCalled());
		assertSame(nematodeVideoFrame.getProcessedFrameImage(),
				edgeDetectionRunner.getProcessedFrameImageToScan());

		fail("test order of operations");
	}
}
