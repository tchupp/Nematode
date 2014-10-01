package com.nematode.imaging;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class SquareContourTracerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(SquareContourTracerInterface.class,
				SquareContourTracer.class);
	}

	@Test
	public void testStaticBlackAndWhiteColorValuesAreCorrect() throws Exception {
		assertEquals(Color.WHITE.getRGB(), SquareContourTracer.WHITE);
		assertEquals(Color.BLACK.getRGB(), SquareContourTracer.BLACK);
	}

	@Test
	public void testFindContourLines() throws Exception {
		final int w = SquareContourTracer.WHITE;
		final int b = SquareContourTracer.BLACK;

		final int[] inputMatrix = new int[] { w, w, w, w, w, w, w, w, w, w, w,
				w, w, b, b, b, w, w, w, w, w, w, b, b, b, b, b, w, w, w, w, w,
				b, b, w, b, b, w, w, w, w, w, w, b, b, w, b, b, w, w, w, w, w,
				w, b, w, b, b, w, w, w, w, w, w, b, b, b, w, w, w, w, w, w, w,
				w, w, w, w, w, w };
		final BlackAndWhiteImage inputImage = new BlackAndWhiteImage(10, 8);
		inputImage.setRGB(0, 0, 10, 8, inputMatrix, 0, 10);

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
				.getContourLines(inputImage).getListOfContourPoints();

		assertEqualListContents(expectedContourPoints, actualContourPoints);
	}
}
