package com.nematode.imaging;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ContourPointsTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ContourPointsInterface.class,
				ContourPoints.class);
	}

	@Test
	public void testGetsListOfContourPoints() throws Exception {
		final ArrayList<ContourPoint> expectedList = new ArrayList<ContourPoint>();

		final ContourPoints contourPoints = new ContourPoints(expectedList);
		assertSame(expectedList, contourPoints.getListOfContourPoints());
	}

	@Test
	public void testGetAllPointsAtVerticalXReturnsCorrectList_AtleastOneFound()
			throws Exception {

		final ContourPoint contourPoint1 = new ContourPoint(2, 1);
		final ContourPoint contourPoint2 = new ContourPoint(2, 3);
		final ContourPoint contourPoint3 = new ContourPoint(3, 1);
		final ContourPoint contourPoint4 = new ContourPoint(3, 2);
		final ContourPoint contourPoint5 = new ContourPoint(3, 3);

		final ArrayList<ContourPoint> inputPoints = new ArrayList<ContourPoint>();
		inputPoints.add(contourPoint1);
		inputPoints.add(contourPoint2);
		inputPoints.add(contourPoint3);
		inputPoints.add(contourPoint4);
		inputPoints.add(contourPoint5);

		final ContourPoints contourPoints = new ContourPoints(inputPoints);

		final ArrayList<ContourPoint> expectedPoints1 = new ArrayList<ContourPoint>();
		expectedPoints1.add(contourPoint1);
		expectedPoints1.add(contourPoint2);

		final ArrayList<ContourPoint> expectedPoints2 = new ArrayList<ContourPoint>();
		expectedPoints2.add(contourPoint3);
		expectedPoints2.add(contourPoint4);
		expectedPoints2.add(contourPoint5);

		final List<ContourPoint> pointsAtX_2 = contourPoints.getPointsAtX(2);
		assertEqualListContents(expectedPoints1, pointsAtX_2);

		final List<ContourPoint> pointsAtX_3 = contourPoints.getPointsAtX(3);
		assertEqualListContents(expectedPoints2, pointsAtX_3);
	}

	@Test
	public void testGetAllPointsAtVerticalXReturnsEmptyList_NoneFound()
			throws Exception {
		final ContourPoint contourPoint = new ContourPoint(3, 2);
		final ArrayList<ContourPoint> inputPoints = new ArrayList<ContourPoint>();
		inputPoints.add(contourPoint);

		final ContourPoints contourPoints = new ContourPoints(inputPoints);

		final List<ContourPoint> pointsAtX = contourPoints.getPointsAtX(2);

		assertEquals(0, pointsAtX.size());
	}

	@Test
	public void testGetAllPointsAtHorizontalYReturnsCorrectList_AtleastOneFound()
			throws Exception {
		final ContourPoint contourPoint1 = new ContourPoint(1, 3);
		final ContourPoint contourPoint2 = new ContourPoint(2, 3);
		final ContourPoint contourPoint3 = new ContourPoint(7, 4);
		final ContourPoint contourPoint4 = new ContourPoint(4, 4);
		final ContourPoint contourPoint5 = new ContourPoint(9, 4);

		final ArrayList<ContourPoint> inputPoints = new ArrayList<ContourPoint>();
		inputPoints.add(contourPoint1);
		inputPoints.add(contourPoint2);
		inputPoints.add(contourPoint3);
		inputPoints.add(contourPoint4);
		inputPoints.add(contourPoint5);

		final ContourPoints contourPoints = new ContourPoints(inputPoints);

		final ArrayList<ContourPoint> expectedPoints1 = new ArrayList<ContourPoint>();
		expectedPoints1.add(contourPoint1);
		expectedPoints1.add(contourPoint2);

		final ArrayList<ContourPoint> expectedPoints2 = new ArrayList<ContourPoint>();
		expectedPoints2.add(contourPoint3);
		expectedPoints2.add(contourPoint4);
		expectedPoints2.add(contourPoint5);

		final List<ContourPoint> pointsAtY_3 = contourPoints.getPointsAtY(3);
		assertEqualListContents(expectedPoints1, pointsAtY_3);

		final List<ContourPoint> pointsAtY_4 = contourPoints.getPointsAtY(4);
		assertEqualListContents(expectedPoints2, pointsAtY_4);
	}

	@Test
	public void testGetAllPointsAtHorizontalYReturnsEmptyList_NoneFound()
			throws Exception {
		final ContourPoint contourPoint = new ContourPoint(2, 3);
		final ArrayList<ContourPoint> inputPoints = new ArrayList<ContourPoint>();
		inputPoints.add(contourPoint);

		final ContourPoints contourPoints = new ContourPoints(inputPoints);

		final List<ContourPoint> pointsAtY = contourPoints.getPointsAtY(2);

		assertEquals(0, pointsAtY.size());
	}
}
