package com.nematode.imaging;

import java.util.ArrayList;

import org.junit.Test;

import com.nematode.fileIO.MockValidatedImageFile;
import com.nematode.gui.MockNematodeVideoFrame;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.model.NematodeWormInterface;
import com.nematode.nullmodel.NullBufferedImage;
import com.nematode.nullmodel.NullFrameImage;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameHandlerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameHandlerInterface.class, VideoFrameHandler.class);
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

		assertSame(expectedFrameImageAssembler, videoFrameHandler.getFrameImageAssembler());
	}

	@Test
	public void testGetsImageProcessingRunner() throws Exception {
		final MockImageProcessingRunner expectedImageProcessingRunner = new MockImageProcessingRunner();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				new MockNematodeVideoFrame(), new MockFrameImageAssembler(),
				expectedImageProcessingRunner, new MockEdgeDetectionRunner());

		assertSame(expectedImageProcessingRunner, videoFrameHandler.getImageProcessingRunner());
	}

	@Test
	public void testGetsEdgeDetectionRunner() throws Exception {
		final MockEdgeDetectionRunner edgeDetectionRunner = new MockEdgeDetectionRunner();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(
				new MockNematodeVideoFrame(), new MockFrameImageAssembler(),
				new MockImageProcessingRunner(), edgeDetectionRunner);

		assertSame(edgeDetectionRunner, videoFrameHandler.getEdgeDetectionRunner());
	}

	@Test
	public void testUpdateDisplayImageFromScannedObjectsSetsNewDisplayImageOnFrameUsingObjectsInImage()
			throws Exception {
		final BlackAndWhiteImage expectedImageWithObjects = new BlackAndWhiteImage(
				new NullBufferedImage());

		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockFrameImageAssembler mockAssembler = new MockFrameImageAssembler();

		final MockDisplayFrameImage expectedDisplayImage = new MockDisplayFrameImage();
		mockAssembler.setDisplayImageToReturn(expectedDisplayImage);

		final MockImageProcessingRunner imageProcessingRunner = new MockImageProcessingRunner();
		imageProcessingRunner.setImageWithObjectsToReturn(expectedImageWithObjects);
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(videoFrame,
				mockAssembler, imageProcessingRunner, new MockEdgeDetectionRunner());

		assertFalse(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertFalse(videoFrame.wasSetDisplayFrameImageCalled());
		assertFalse(imageProcessingRunner.wasCreateImageWithIdentifiedObjectsCalled());

		videoFrameHandler.updateDisplayImageFromScannedObjects();

		assertTrue(imageProcessingRunner.wasCreateImageWithIdentifiedObjectsCalled());
		assertSame(videoFrame, imageProcessingRunner.getVideoFrameDrawn());

		assertTrue(mockAssembler.wasCreateDisplayFrameImageCalled());
		assertSame(expectedImageWithObjects, mockAssembler.getDisplayImageToCreate());

		assertTrue(videoFrame.wasSetDisplayFrameImageCalled());
		assertSame(expectedDisplayImage, videoFrame.getDisplayFrameImage());
	}

	@Test
	public void testBuildNewFrameImage_WithValidImage_CallsCreateFromFrameAssembler()
			throws Exception {
		final MockNematodeVideoFrame videoFrame = new MockNematodeVideoFrame();
		final MockFrameImageAssembler mockAssembler = new MockFrameImageAssembler();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(videoFrame,
				mockAssembler, new MockImageProcessingRunner(), new MockEdgeDetectionRunner());

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
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(videoFrame,
				mockAssembler, new MockImageProcessingRunner(), new MockEdgeDetectionRunner());

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

		assertIsOfTypeAndGet(NullFrameImage.class, videoFrame.getVideoFrameImage());
		assertIsOfTypeAndGet(NullFrameImage.class, videoFrame.getDisplayFrameImage());
	}

	@Test
	public void testScanImageCallsImageProcessingRunnerWithVideoFrame_CorrectOrder()
			throws Exception {
		final MockImageProcessingRunner imageProcessingRunner = new MockImageProcessingRunner();
		final MockEdgeDetectionRunner edgeDetectionRunner = new MockEdgeDetectionRunner();

		final MockNematodeVideoFrame nematodeVideoFrame = new MockNematodeVideoFrame();
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(nematodeVideoFrame,
				new MockFrameImageAssembler(), imageProcessingRunner, edgeDetectionRunner);

		assertFalse(imageProcessingRunner.wasPreprocessImageForScanningCalled());
		assertFalse(edgeDetectionRunner.wasFindAllObjectsInImageCalled());

		videoFrameHandler.scanImage();

		assertTrue(imageProcessingRunner.wasPreprocessImageForScanningCalled());
		assertSame(nematodeVideoFrame, imageProcessingRunner.getUnprocessedVideoFrame());

		assertTrue(edgeDetectionRunner.wasFindAllObjectsInImageCalled());
	}

	@Test
	public void testScanImageSetsListOfObjectsOnVideoFrame() throws Exception {
		final MockNematodeVideoFrame nematodeVideoFrame = new MockNematodeVideoFrame();
		final MockEdgeDetectionRunner edgeDetectionRunner = new MockEdgeDetectionRunner();
		final ArrayList<NematodeWormInterface> expectedObjectsInImageList = new ArrayList<NematodeWormInterface>();
		edgeDetectionRunner.setObjectsInImageList(expectedObjectsInImageList);
		final VideoFrameHandler videoFrameHandler = new VideoFrameHandler(nematodeVideoFrame,
				new MockFrameImageAssembler(), new MockImageProcessingRunner(), edgeDetectionRunner);

		assertFalse(nematodeVideoFrame.wasSetObjectsOnImageCalled());

		videoFrameHandler.scanImage();

		assertTrue(nematodeVideoFrame.wasSetObjectsOnImageCalled());
		assertSame(expectedObjectsInImageList, nematodeVideoFrame.getObjectsOnImage());
	}
}
