package com.nematode.gui;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class StatusMessageTest extends AssertTestCase {

	@Test
	public void testStatusMessages() throws Exception {
		assertEquals("Single Image Loaded", StatusMessage.LOADED_IMAGE);
		assertEquals("Object Identified", StatusMessage.OBJECT_FOUND);
		assertEquals("Scanning Completed", StatusMessage.SCANNING_FINISHED);
		assertEquals("Preprocessing Completed", StatusMessage.PREPROCESSING_FINISHED);
	}

}
