package com.nematode.imaging;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ContourAreaTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ContourAreaInterface.class, ContourArea.class);
	}

	@Test
	public void testGetListOfInnerPoints() throws Exception {
		final List<InnerPointInterface> expectedList = new ArrayList<InnerPointInterface>();
		final ContourArea contourArea = new ContourArea(expectedList);
		assertSame(expectedList, contourArea.getListOfInnerPoints());
	}

	@Test
	public void testGetSizeReturnsNumberOfPointsInside() throws Exception {
		final ContourArea contourArea_Zero = new ContourArea(
				new ArrayList<InnerPointInterface>());

		assertEquals(0, contourArea_Zero.getSize());

		final List<InnerPointInterface> expectedList = new ArrayList<InnerPointInterface>();
		expectedList.add(new MockInnerPoint());
		expectedList.add(new MockInnerPoint());
		final ContourArea contourArea = new ContourArea(expectedList);
		assertEquals(2, contourArea.getSize());
	}
}
