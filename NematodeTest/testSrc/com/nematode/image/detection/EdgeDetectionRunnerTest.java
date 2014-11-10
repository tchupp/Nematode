package com.nematode.image.detection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.image.BlackAndWhiteImage;
import com.nematode.image.MockContourLines;
import com.nematode.image.MockImageProcessingHelper;
import com.nematode.image.MockProcessedFrameImage;
import com.nematode.image.MockSquareContourTracer;
import com.nematode.image.NullBufferedImage;
import com.nematode.model.MockNematodeWormBuilder;
import com.nematode.model.NematodeWormInterface;
import com.nematode.unittesting.AssertTestCase;

public class EdgeDetectionRunnerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(EdgeDetectionRunnerInterface.class, EdgeDetectionRunner.class);
	}

	@Test
	public void testGetsSquareContourTracer() throws Exception {
		final MockSquareContourTracer contourTracer = new MockSquareContourTracer();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(contourTracer,
				new MockNematodeWormBuilder(), new MockImageProcessingHelper());

		assertSame(contourTracer, edgeDetectionRunner.getContourTracer());
	}

	@Test
	public void testGetsNematodeWormBuilder() throws Exception {
		final MockNematodeWormBuilder mockWormBuilder = new MockNematodeWormBuilder();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				new MockSquareContourTracer(), mockWormBuilder, new MockImageProcessingHelper());

		assertSame(mockWormBuilder, edgeDetectionRunner.getNematodeWormBuilder());
	}

	@Test
	public void testGetsImageProcessingHelper() throws Exception {
		final MockImageProcessingHelper imageProcessingHelper = new MockImageProcessingHelper();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				new MockSquareContourTracer(), new MockNematodeWormBuilder(), imageProcessingHelper);

		assertSame(imageProcessingHelper, edgeDetectionRunner.getImageProcessingHelper());
	}

	@Test
	public void testFindAllObjectsInImageReturnsListOfWormsOfCorrectSize() throws Exception {
		final ArrayList<ContourLinesInterface> contourLinesList = new ArrayList<ContourLinesInterface>();
		final MockContourLines mockContourLines = new MockContourLines();
		final MockContourLines emptyContourLines = new MockContourLines();
		emptyContourLines.setEmpty(true);
		contourLinesList.add(mockContourLines);
		contourLinesList.add(emptyContourLines);

		final MockSquareContourTracer contourTracer = new MockSquareContourTracer();
		contourTracer.setListOfLinesToReturn(contourLinesList);

		final MockNematodeWormBuilder nematodeWormBuilder = new MockNematodeWormBuilder();
		final MockImageProcessingHelper imageProcessingHelper = new MockImageProcessingHelper();
		final BlackAndWhiteImage expectedImageWithRemovedObject = new BlackAndWhiteImage(
				new NullBufferedImage());
		imageProcessingHelper.setRemoveObjectImageToReturn(expectedImageWithRemovedObject);

		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(contourTracer,
				nematodeWormBuilder, imageProcessingHelper);

		final MockProcessedFrameImage processedFrameImage = new MockProcessedFrameImage();

		assertFalse(contourTracer.wasGetFirstContourLinesCalled());
		assertFalse(imageProcessingHelper.wasRemoveObjectFromImageCalled());
		assertFalse(nematodeWormBuilder.wasBuildWormCalled());

		final List<NematodeWormInterface> objectsFromImage = edgeDetectionRunner
				.findAllObjectsInImage(processedFrameImage);
		assertEquals(1, objectsFromImage.size());

		assertTrue(contourTracer.wasGetFirstContourLinesCalled());
		assertSame(expectedImageWithRemovedObject, contourTracer.getScannedImage());

		assertTrue(imageProcessingHelper.wasRemoveObjectFromImageCalled());
		assertSame(imageProcessingHelper.getOriginalRemovalImage(), processedFrameImage.getImage());
		assertSame(objectsFromImage.get(0), imageProcessingHelper.getWormToRemove());

		assertTrue(nematodeWormBuilder.wasBuildWormCalled());
		assertSame(mockContourLines, nematodeWormBuilder.getContourLinesBuiltWith());
	}
}
