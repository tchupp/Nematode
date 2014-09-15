package com.nematode.imaging;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ImageProcessingRunnerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ImageProcessingRunnerInterface.class,
				ImageProcessingRunner.class);
	}

}
