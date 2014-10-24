package com.nematode.image.detection;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ContourPointTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ContourPointInterface.class, ContourPoint.class);
	}

	@Test
	public void testDirectionReturnsCorrectInt() throws Exception {
		assertEquals(0, ContourPoint.DIR_NORTH);
		assertEquals(1, ContourPoint.DIR_EAST);
		assertEquals(2, ContourPoint.DIR_SOUTH);
		assertEquals(3, ContourPoint.DIR_WEST);
	}

	@Test
	public void testDefaultConstructorPointsNorth_StartsAtTopLeft() throws Exception {
		final ContourPoint contourPoint = new ContourPoint();

		assertEquals(0, contourPoint.getX());
		assertEquals(0, contourPoint.getY());
		assertEquals(ContourPoint.DIR_NORTH, contourPoint.getDirection());
	}

	@Test
	public void testDefaultDirectionIsEast() throws Exception {
		final int expectedX = 7;
		final int expectedY = 5;
		final ContourPoint contourPoint = new ContourPoint(expectedX, expectedY);

		assertEquals(expectedX, contourPoint.getX());
		assertEquals(expectedY, contourPoint.getY());
		assertEquals(ContourPoint.DIR_NORTH, contourPoint.getDirection());
	}

	@Test
	public void testCopyConstructor() throws Exception {
		final int expectedX = 6;
		final int expectedY = 4;
		final ContourPoint expectedPoint = new ContourPoint(expectedX, expectedY,
				ContourPoint.DIR_SOUTH);
		final ContourPoint actualPoint = new ContourPoint(expectedPoint);

		assertEquals(expectedPoint, actualPoint);
		assertEquals(expectedPoint.getDirection(), actualPoint.getDirection());
	}

	@Test
	public void testOverrideEqualsDoesntCareAboutDirection() throws Exception {
		final ContourPoint equalPointOne = new ContourPoint(4, 5, ContourPoint.DIR_EAST);
		final ContourPoint equalPointTwo = new ContourPoint(4, 5, ContourPoint.DIR_SOUTH);
		final ContourPoint nonequalPoint = new ContourPoint(6, 4, ContourPoint.DIR_SOUTH);

		assertEquals(equalPointOne, equalPointTwo);
		assertNotEquals(equalPointOne, nonequalPoint);
	}

	@Test
	public void testAdvanceRightCorrectlyAdvancesDirection() throws Exception {
		final ContourPoint contourPoint = new ContourPoint(0, 0);
		assertEquals(ContourPoint.DIR_NORTH, contourPoint.getDirection());
		contourPoint.advanceRight();
		assertEquals(1, contourPoint.getX());
		assertEquals(0, contourPoint.getY());
		assertEquals(ContourPoint.DIR_EAST, contourPoint.getDirection());
	}

	@Test
	public void testAdvanceLeftCorrectlyAdvancesDirection() throws Exception {
		final ContourPoint contourPoint = new ContourPoint(0, 0);
		assertEquals(ContourPoint.DIR_NORTH, contourPoint.getDirection());
		contourPoint.advanceLeft();
		assertEquals(-1, contourPoint.getX());
		assertEquals(0, contourPoint.getY());
		assertEquals(ContourPoint.DIR_WEST, contourPoint.getDirection());
	}

	@Test
	public void testInvalidFlagSetIfEitherOfThePositionArgumentsAreNegative() throws Exception {
		final ContourPoint invalidPointOne = new ContourPoint(-1, 0);
		final ContourPoint invalidPointTwo = new ContourPoint(7, -1);
		final ContourPoint validPoint = new ContourPoint(4, 1);

		assertFalse(invalidPointOne.isValid());
		assertFalse(invalidPointTwo.isValid());
		assertTrue(validPoint.isValid());
	}

	@Test
	public void testTestToString() throws Exception {
		final ContourPoint defaultContourPoint = new ContourPoint();
		final ContourPoint nonDefaultContourPoint = new ContourPoint(5, 6);

		assertEquals("com.nematode.image.detection.ContourPoint [0, 0]",
				defaultContourPoint.toString());
		assertEquals("com.nematode.image.detection.ContourPoint [5, 6]",
				nonDefaultContourPoint.toString());
	}

	@Test
	public void testCloneReturnsEqualObjectWithDifferentAddress() throws Exception {
		final ContourPoint origanalContourPoint = new ContourPoint(2, 3);
		final ContourPoint clonedContourPoint = origanalContourPoint.clone();
		assertEquals(origanalContourPoint, clonedContourPoint);
		assertEquals(origanalContourPoint.getDirection(), clonedContourPoint.getDirection());
		assertNotSame(origanalContourPoint, clonedContourPoint);
	}
}
