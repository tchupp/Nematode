package com.nematode.image.detection;

import java.util.List;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NullContourAreaTest extends AssertTestCase {

	@Test
	public void testGetListOfInnerPointsReturnsEmptyList() throws Exception {
		final NullContourArea nullContourArea = new NullContourArea();
		final List<InnerPointInterface> listOfInnerPoints = nullContourArea.getListOfInnerPoints();

		assertEquals(0, listOfInnerPoints.size());
	}

	@Test
	public void testGetSizeReturnsNegativeOne() throws Exception {
		final NullContourArea nullContourArea = new NullContourArea();
		assertEquals(-1, nullContourArea.getSize());
	}

}
