package com.nematode.image.detection;

import org.junit.Test;

import com.nematode.image.detection.InnerPoint;
import com.nematode.image.detection.InnerPointInterface;
import com.nematode.unittesting.AssertTestCase;

public class InnerPointTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(InnerPointInterface.class, InnerPoint.class);
	}

	@Test
	public void testGetsXAndY() throws Exception {
		final int expectedX = 7;
		final int expectedY = 3;

		final InnerPoint innerPoint = new InnerPoint(expectedX, expectedY);

		assertEquals(expectedX, innerPoint.getX());
		assertEquals(expectedY, innerPoint.getY());
	}

	@Test
	public void testIsValid() throws Exception {
		final InnerPoint nonValidInnerPoint = new InnerPoint(-4, 8);
		assertFalse(nonValidInnerPoint.isValid());

		final InnerPoint validInnerPoints = new InnerPoint(3, 4);
		assertTrue(validInnerPoints.isValid());
	}

	@Test
	public void testCloneReturnsEqualObjectDifferentAddress() throws Exception {
		final InnerPoint innerPoint = new InnerPoint(1, 3);
		final InnerPoint clone = innerPoint.clone();
		assertEquals(innerPoint, clone);
		assertNotSame(innerPoint, clone);
	}

	@Test
	public void testOverridenEquals() throws Exception {
		final InnerPoint innerPoint1 = new InnerPoint(5, 6);
		final InnerPoint innerPoint2 = new InnerPoint(5, 6);

		assertEquals(innerPoint1, innerPoint2);
	}

	@Test
	public void testToString() throws Exception {
		final InnerPoint innerPoint = new InnerPoint(7, 8);

		assertEquals("com.nematode.imaging.InnerPoint [7, 8]",
				innerPoint.toString());
	}

}
