package com.nematode.imaging;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class SquareContourTracerTest extends AssertTestCase {

	@Test
	public void testStaticBlackAndWhiteColorValuesAreCorrect() throws Exception {
		assertEquals(Color.WHITE.getRGB(), SquareContourTracer.WHITE);
		assertEquals(Color.BLACK.getRGB(), SquareContourTracer.BLACK);
	}

	@Test
	public void testFindContourLines() throws Exception {

		final int[][] inputMatrix = new int[][] {
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		final ArrayList<ContourPoint> expectedContourPoints = new ArrayList<ContourPoint>();
		expectedContourPoints.add(new ContourPoint(6, 6));
		expectedContourPoints.add(new ContourPoint(5, 6));
		expectedContourPoints.add(new ContourPoint(4, 6));
		expectedContourPoints.add(new ContourPoint(4, 5));
		expectedContourPoints.add(new ContourPoint(4, 4));
		expectedContourPoints.add(new ContourPoint(3, 4));
		expectedContourPoints.add(new ContourPoint(3, 3));
		expectedContourPoints.add(new ContourPoint(2, 3));
		expectedContourPoints.add(new ContourPoint(2, 2));
		expectedContourPoints.add(new ContourPoint(3, 2));
		expectedContourPoints.add(new ContourPoint(3, 1));
		expectedContourPoints.add(new ContourPoint(4, 1));
		expectedContourPoints.add(new ContourPoint(5, 1));
		expectedContourPoints.add(new ContourPoint(6, 2));
		expectedContourPoints.add(new ContourPoint(6, 3));
		expectedContourPoints.add(new ContourPoint(6, 4));
		expectedContourPoints.add(new ContourPoint(7, 4));
		expectedContourPoints.add(new ContourPoint(7, 5));
		expectedContourPoints.add(new ContourPoint(6, 5));

		final SquareContourTracer squareContourTracer = new SquareContourTracer();
		final List<ContourPoint> actualContourPoints = squareContourTracer
				.getContourPoints(inputMatrix);

		assertEqualListContents(expectedContourPoints, actualContourPoints);
	}
}
