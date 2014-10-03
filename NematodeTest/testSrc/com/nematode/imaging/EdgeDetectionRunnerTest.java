package com.nematode.imaging;

import org.junit.Test;

import com.nematode.model.MockNematodeWormBuilder;
import com.nematode.unittesting.AssertTestCase;

public class EdgeDetectionRunnerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(EdgeDetectionRunnerInterface.class,
				EdgeDetectionRunner.class);
	}

	@Test
	public void testGetsSquareContourTracer() throws Exception {
		final MockSquareContourTracer contourTracer = new MockSquareContourTracer();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				contourTracer, new MockNematodeWormBuilder(),
				new MockImageProcessingHelper());

		assertSame(contourTracer, edgeDetectionRunner.getContourTracer());
	}

	@Test
	public void testGetsNematodeWormBuilder() throws Exception {
		final MockNematodeWormBuilder mockWormBuilder = new MockNematodeWormBuilder();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				new MockSquareContourTracer(), mockWormBuilder,
				new MockImageProcessingHelper());

		assertSame(mockWormBuilder,
				edgeDetectionRunner.getNematodeWormBuilder());
	}

	@Test
	public void testGetsImageProcessingHelper() throws Exception {
		final MockImageProcessingHelper imageProcessingHelper = new MockImageProcessingHelper();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				new MockSquareContourTracer(), new MockNematodeWormBuilder(),
				imageProcessingHelper);

		assertSame(imageProcessingHelper,
				edgeDetectionRunner.getImageProcessingHelper());
	}

	@Test
	public void testFindAllObjectsInImageReturnsListOfWormsOfCorrectSize()
			throws Exception {

		final MockProcessedFrameImage processedFrameImage = new MockProcessedFrameImage();

		final MockSquareContourTracer contourTracer = new MockSquareContourTracer();
		final MockNematodeWormBuilder nematodeWormBuilder = new MockNematodeWormBuilder();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				contourTracer, nematodeWormBuilder,
				new MockImageProcessingHelper());

		assertFalse(contourTracer.wasGetFirstContourLinesCalled());
		assertFalse(nematodeWormBuilder.wasBuildWormCalled());

		edgeDetectionRunner.findAllObjectsInImage(processedFrameImage);

		assertTrue(contourTracer.wasGetFirstContourLinesCalled());
		assertTrue(nematodeWormBuilder.wasBuildWormCalled());

		fail("unimplemented");
	}
}
