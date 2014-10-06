package com.nematode.imaging;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ContourLinesTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ContourLinesInterface.class,
				ContourLines.class);
	}

	@Test
	public void testGetsListOfContourPoints() throws Exception {
		final ArrayList<ContourPointInterface> expectedList = new ArrayList<ContourPointInterface>();

		final ContourLines contourLines = new ContourLines(expectedList);
		assertSame(expectedList, contourLines.getListOfContourPoints());
	}

	@Test
	public void testGetAllPointsAtVerticalXReturnsCorrectList_AtleastOneFound()
			throws Exception {

		final ContourPoint contourPoint1 = new ContourPoint(2, 1);
		final ContourPoint contourPoint2 = new ContourPoint(2, 3);
		final ContourPoint contourPoint3 = new ContourPoint(3, 1);
		final ContourPoint contourPoint4 = new ContourPoint(3, 2);
		final ContourPoint contourPoint5 = new ContourPoint(3, 3);

		final List<ContourPointInterface> inputPoints = new ArrayList<ContourPointInterface>();
		inputPoints.add(contourPoint1);
		inputPoints.add(contourPoint2);
		inputPoints.add(contourPoint3);
		inputPoints.add(contourPoint4);
		inputPoints.add(contourPoint5);

		final ContourLines contourLines = new ContourLines(inputPoints);

		final List<ContourPointInterface> expectedPoints1 = new ArrayList<ContourPointInterface>();
		expectedPoints1.add(contourPoint1);
		expectedPoints1.add(contourPoint2);

		final List<ContourPointInterface> expectedPoints2 = new ArrayList<ContourPointInterface>();
		expectedPoints2.add(contourPoint3);
		expectedPoints2.add(contourPoint4);
		expectedPoints2.add(contourPoint5);

		final List<ContourPointInterface> pointsAtX_2 = contourLines
				.getPointsAtX(2);
		assertEqualListContents(expectedPoints1, pointsAtX_2);

		final List<ContourPointInterface> pointsAtX_3 = contourLines
				.getPointsAtX(3);
		assertEqualListContents(expectedPoints2, pointsAtX_3);
	}

	@Test
	public void testGetAllPointsAtVerticalXReturnsEmptyList_NoneFound()
			throws Exception {
		final ContourPoint contourPoint = new ContourPoint(3, 2);
		final List<ContourPointInterface> inputPoints = new ArrayList<ContourPointInterface>();
		inputPoints.add(contourPoint);

		final ContourLines contourLines = new ContourLines(inputPoints);

		final List<ContourPointInterface> pointsAtX = contourLines
				.getPointsAtX(2);

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

		final List<ContourPointInterface> inputPoints = new ArrayList<ContourPointInterface>();
		inputPoints.add(contourPoint1);
		inputPoints.add(contourPoint2);
		inputPoints.add(contourPoint3);
		inputPoints.add(contourPoint4);
		inputPoints.add(contourPoint5);

		final ContourLines contourLines = new ContourLines(inputPoints);

		final List<ContourPointInterface> expectedPoints1 = new ArrayList<ContourPointInterface>();
		expectedPoints1.add(contourPoint1);
		expectedPoints1.add(contourPoint2);

		final List<ContourPointInterface> expectedPoints2 = new ArrayList<ContourPointInterface>();
		expectedPoints2.add(contourPoint3);
		expectedPoints2.add(contourPoint4);
		expectedPoints2.add(contourPoint5);

		final List<ContourPointInterface> pointsAtY_3 = contourLines
				.getPointsAtY(3);
		assertEqualListContents(expectedPoints1, pointsAtY_3);

		final List<ContourPointInterface> pointsAtY_4 = contourLines
				.getPointsAtY(4);
		assertEqualListContents(expectedPoints2, pointsAtY_4);
	}

	@Test
	public void testGetAllPointsAtHorizontalYReturnsEmptyList_NoneFound()
			throws Exception {
		final ContourPoint contourPoint = new ContourPoint(2, 3);
		final ArrayList<ContourPointInterface> inputPoints = new ArrayList<ContourPointInterface>();
		inputPoints.add(contourPoint);

		final ContourLines contourLines = new ContourLines(inputPoints);

		final List<ContourPointInterface> pointsAtY = contourLines
				.getPointsAtY(2);

		assertEquals(0, pointsAtY.size());
	}

	@Test
	public void testIsEmptyReturnsCorrectBoolean() throws Exception {
		final ContourLines emptyContourLines = new ContourLines(
				new ArrayList<ContourPointInterface>());
		assertTrue(emptyContourLines.isEmpty());

		final List<ContourPointInterface> listOfContourPoints = new ArrayList<ContourPointInterface>();
		listOfContourPoints.add(new MockContourPoint());

		final ContourLines nonEmptyContourLines = new ContourLines(
				listOfContourPoints);
		assertFalse(nonEmptyContourLines.isEmpty());
	}
}
