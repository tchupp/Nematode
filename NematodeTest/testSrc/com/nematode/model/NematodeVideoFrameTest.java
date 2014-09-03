package com.nematode.model;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class NematodeVideoFrameTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {

		assertImplementsInterface(NematodeVideoFrameInterface.class,
				NematodeVideoFrame.class);
	}
}
