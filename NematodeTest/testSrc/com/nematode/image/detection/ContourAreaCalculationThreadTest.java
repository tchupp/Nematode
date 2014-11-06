package com.nematode.image.detection;

import org.junit.Test;

import com.nematode.image.MockContourArea;
import com.nematode.image.MockContourAreaCalculator;
import com.nematode.model.MockNematodeWorm;
import com.nematode.unittesting.AssertTestCase;

public class ContourAreaCalculationThreadTest extends AssertTestCase {

	@Test
	public void testExtendsThread() throws Exception {
		assertExtends(Thread.class, ContourAreaCalculationThread.class);
	}

	@Test
	public void testGetsNematodeWormPassedIn() throws Exception {
		final MockNematodeWorm mockNematodeWorm = new MockNematodeWorm();
		final ContourAreaCalculationThread calculationThread = new ContourAreaCalculationThread(
				mockNematodeWorm, new MockContourAreaCalculator());
		assertSame(mockNematodeWorm, calculationThread.getWorm());
	}

	@Test
	public void testGetsContourAreaCalculatorPassedIn() throws Exception {
		final MockContourAreaCalculator areaCalculator = new MockContourAreaCalculator();
		final ContourAreaCalculationThread calculationThread = new ContourAreaCalculationThread(
				new MockNematodeWorm(), areaCalculator);
		assertSame(areaCalculator, calculationThread.getAreaCalculator());
	}

	@Test
	public void testRunThreadCallsGetAreaWithTheWorm_ThenSetsTheAreaOnTheWorm() throws Exception {
		final MockContourArea expectedArea = new MockContourArea();

		final MockContourAreaCalculator areaCalculator = new MockContourAreaCalculator();
		areaCalculator.setAreaToReturn(expectedArea);

		final MockNematodeWorm expectedWorm = new MockNematodeWorm();
		final ContourAreaCalculationThread calculationThread = new ContourAreaCalculationThread(
				expectedWorm, areaCalculator);

		assertFalse(areaCalculator.wasGetAreaCalled());
		calculationThread.run();
		assertTrue(areaCalculator.wasGetAreaCalled());

		assertSame(expectedWorm, areaCalculator.getWormPassedInGetArea());

		assertTrue(expectedWorm.wasSetContourAreaCalled());
		assertSame(expectedArea, expectedWorm.getContourArea());
	}
}
