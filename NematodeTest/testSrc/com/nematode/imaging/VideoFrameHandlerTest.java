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
				new MockImageProcessingRunner());

		final NematodeVideoFrameInterface actualNematodeVideoFrame = videoFrameHandler
				.getNematodeVideoFrame();
		assertSame(expectedNematodeVideoFrame, actualNematodeVideoFrame);
	}

	@Test
	public void testGetsFrameImageAssembler() throws Exception {
		final MockFrameImageAssembler expectedFrameImageAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				new MockNematodeVideoFrame(), expectedFrameImageAssembler,
				new MockImageProcessingRunner());

		assertSame(expectedFrameImageAssembler,
				videoFrameHandler.getFrameImageAssembler());
	}

	@Test
	public void testGetsImageProcessingRunner() throws Exception {
		final MockImageProcessingRunner expectedImageProcessingRunner = new MockImageProcessingRunner();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				new MockNematodeVideoFrame(), new MockFrameImageAssembler(),
				expectedImageProcessingRunner);

		assertSame(expectedImageProcessingRunner,
				videoFrameHandler.getImageProcessingRunner());
	}

	@Test
	public void testUpdateDisplayImageSetsNewDisplayImageOnFrame()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockFrameImageAssembler mockAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				videoFrame, mockAssembler, new MockImageProcessingRunner());

		assertFalse(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertFalse(videoFrame.wasSetDisplayFrameImageCalled());
		videoFrameHandler.updateDisplayImage();
		assertTrue(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertTrue(videoFrame.wasSetDisplayFrameImageCalled());
	}

	@Test
	public void testBuildNewFrameImage_WithValidImage_CallsCreateFromFrameAssembler()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockFrameImageAssembler mockAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				videoFrame, mockAssembler, new MockImageProcessingRunner());

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
				videoFrame, mockAssembler, new MockImageProcessingRunner());

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
	public void testScanImageCallsImageProcessingRunnerWithVideoFrame()
			throws Exception {

		final MockNematodeVideoFrame mockVideoFrame = new MockNematodeVideoFrame();
		final MockImageProcessingRunner mockImageProcessingRunner = new MockImageProcessingRunner();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				mockVideoFrame, new MockFrameImageAssembler(),
				mockImageProcessingRunner);

		assertFalse(mockImageProcessingRunner.wasScanVideoFrameCalled());
		videoFrameHandler.scanImage();
		assertTrue(mockImageProcessingRunner.wasScanVideoFrameCalled());

		assertSame(mockVideoFrame,
				mockImageProcessingRunner.getVideoFrameFromScan());
	}
}