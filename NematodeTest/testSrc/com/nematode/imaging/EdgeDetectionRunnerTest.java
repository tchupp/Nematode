package com.nematode.imaging;

import org.junit.Test;

import com.nematode.model.MockNematodeWormBuilder;
import com.nematode.unittesting.AssertTestCase;

public class EdgeDetectionRunnerTest extends AssertTestCase {

	@Test
	public void testGetsSquareContourTracer() throws Exception {
		final MockSquareContourTracer contourTracer = new MockSquareContourTracer();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				contourTracer, new MockNematodeWormBuilder());

		assertSame(contourTracer, edgeDetectionRunner.getContourTracer());
	}

	@Test
	public void testGetsNematodeWormBuilder() throws Exception {
		final MockNematodeWormBuilder mockWormBuilder = new MockNematodeWormBuilder();
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				new MockSquareContourTracer(), mockWormBuilder);

		assertSame(mockWormBuilder,
				edgeDetectionRunner.getNematodeWormBuilder());
	}
}
